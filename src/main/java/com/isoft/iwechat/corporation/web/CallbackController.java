package com.isoft.iwechat.corporation.web;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.isoft.iwechat.core.aes.WXBizMsgCrypt;
import com.isoft.iwechat.corporation.configuration.CorpProperties;
import com.isoft.iwechat.corporation.message.reception.*;
import com.isoft.iwechat.corporation.message.reception.event.*;
import com.isoft.iwechat.corporation.message.reception.response.AbstractResponseMessage;
import com.isoft.iwechat.corporation.message.reception.response.ResponseImageMessage;
import com.isoft.iwechat.corporation.message.reception.response.ResponseTextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class CallbackController {
    @Autowired
    private CorpProperties properties;

    private XmlMapper xmlMapper = new XmlMapper();

    private Logger logger = LoggerFactory.getLogger(CallbackController.class);

    /**
     * 回调验证
     *
     * @param signature 企业微信加密签名，msg_signature结合了企业填写的token、请求中的timestamp、nonce参数、加密的消息体
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   加密的随机字符串，以msg_encrypt格式提供。需要解密并返回echostr明文，解密后有random、msg_len、msg、$CorpID四个字段，其中msg即为echostr明文
     * @return echostr 明文(不能加引号，不能带bom头，不能带换行符)
     */
    @ResponseBody
    @GetMapping(produces = "text/plain")
    public String get(@RequestParam(name = "msg_signature") String signature,
                      @RequestParam String timestamp,
                      @RequestParam String nonce,
                      @RequestParam String echostr) {
        String result = null;

        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(properties.getCorpToken(), properties.getCorpKey(), properties.getCorpId());

            result = wxcpt.VerifyURL(signature, timestamp,
                    nonce, echostr);
            logger.info("企业微信回调接口验证成功，echostr：" + result);

        } catch (Exception e) {
            logger.error("企业微信回调接口认证失败，失败原因：" + e.getMessage());
        }

        return result;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity receive(@RequestParam(name = "msg_signature") String signature,
                                  @RequestParam String timestamp,
                                  @RequestParam String nonce,
                                  @RequestBody String data) {
        String result = null;

        try {
            AbstractResponseMessage responseMessage = null;
            boolean handled = false;
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(properties.getCorpToken(), properties.getCorpKey(), properties.getCorpId());

            String body = wxcpt.DecryptMsg(signature, timestamp, nonce, data);
            Document doc = DocumentHelper.parseText(body);
            Element root = doc.getRootElement();
            String msgType = root.elementTextTrim("MsgType");

            if (StringUtils.isEmpty(msgType)) {
                throw new IllegalStateException("MsgType 不能为空!");
            }

            logger.info("收到微信推送消息，消息类型为：" + msgType + ", 消息内容： " + body);
            if (msgType.equals(ReceptionMessageType.event.name())) {
                String event = root.elementTextTrim("Event");
                responseMessage = doProcessEvent(event, body, root);
                handled = true;
            } else if (msgType.equals(ReceptionMessageType.text.name())) {
                TextMessage message = xmlMapper.readValue(body, TextMessage.class);
                responseMessage = processTextMessage(message);
                handled = true;
            } else if (msgType.equals(ReceptionMessageType.image.name())) {
                ImageMessage message = xmlMapper.readValue(body, ImageMessage.class);
                responseMessage = processImageMessage(message);
                handled = true;
            } else if (msgType.equals(ReceptionMessageType.voice.name())) {
                VoiceMessage message = xmlMapper.readValue(body, VoiceMessage.class);
                responseMessage = processVoiceMessage(message);
                handled = true;
            } else if (msgType.equals(ReceptionMessageType.video.name())) {
                VideoMessage message = xmlMapper.readValue(body, VideoMessage.class);
                responseMessage = processVideoMessage(message);
                handled = true;
            } else if (msgType.equals(ReceptionMessageType.location.name())) {
                LocationMessage message = xmlMapper.readValue(body, LocationMessage.class);
                responseMessage = processLocationMessage(message);
            } else if (msgType.equals(ReceptionMessageType.link.name())) {
                LinkMessage message = xmlMapper.readValue(body, LinkMessage.class);
                responseMessage = processLinkMessage(message);
                handled = true;
            }

            if (!handled) {
                throw new IllegalStateException("MsgType：" + msgType + "暂不支持！");
            }

            if (responseMessage != null) {
                String xml = xmlMapper.writeValueAsString(responseMessage);
                result = wxcpt.EncryptMsg(xml, timestamp, nonce);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 处理发送链接消息
     *
     * @param message
     */
    private AbstractResponseMessage processLinkMessage(LinkMessage message) {
        return null;
    }

    /**
     * 处理地理位置消息
     *
     * @param message
     */
    private AbstractResponseMessage processLocationMessage(LocationMessage message) {
        return null;
    }

    /**
     * 处理视频消息
     *
     * @param message
     */
    private AbstractResponseMessage processVideoMessage(VideoMessage message) {
        return null;
    }

    /**
     * 处理声音消息
     *
     * @param message
     */
    private AbstractResponseMessage processVoiceMessage(VoiceMessage message) {
        return null;
    }

    /**
     * 处理图片消息
     *
     * @param message
     */
    private AbstractResponseMessage processImageMessage(ImageMessage message) {
        ResponseImageMessage imageMessage = new ResponseImageMessage();
        imageMessage.setMediaId(message.getMediaId());
        imageMessage.setCreateTime(1);
        imageMessage.setFromUserName(message.getToUserName());
        imageMessage.setToUserName(message.getFromUserName());
        return imageMessage;
    }

    /**
     * 处理文本消息
     *
     * @param message
     */
    private AbstractResponseMessage processTextMessage(TextMessage message) {
        ResponseTextMessage msg = new ResponseTextMessage();

        msg.setFromUserName(message.getToUserName());
        msg.setToUserName(message.getFromUserName());
        msg.setContent("收到文本消息:" + message.getContent());
        msg.setCreateTime(1);

        return msg;
    }

    /**
     * 处理事件消息
     *
     * @param eventType
     * @param data
     * @param root
     * @throws Exception
     */
    private AbstractResponseMessage doProcessEvent(String eventType, String data, Element root) throws Exception {
        if (StringUtils.isEmpty(eventType)) {
            throw new IllegalStateException("Event 不能为空!");
        }

        if (eventType.equals(EventType.subscribe.name())) {
            SubscribeEvent message = xmlMapper.readValue(data, SubscribeEvent.class);
            return processSubscribeEvent(message);
        } else if (eventType.equals(EventType.unsubscribe.name())) {
            UnSubscribeEvent message = xmlMapper.readValue(data, UnSubscribeEvent.class);
            return processUnSubscribeEvent(message);
        } else if (eventType.equals(EventType.enter_agent.name())) {
            EnterAgentEvent message = xmlMapper.readValue(data, EnterAgentEvent.class);
            return processEnterAgentEvent(message);
        } else if (eventType.equals(EventType.LOCATION.name())) {
            LocationEvent message = xmlMapper.readValue(data, LocationEvent.class);
            return processLocationEvent(message);
        } else if (eventType.equals(EventType.batch_job_result.name())) {
            BatchJobEvent message = xmlMapper.readValue(data, BatchJobEvent.class);
            return processBatchJobResultEvent(message);
        } else if (eventType.equals(EventType.change_contact.name())) {
            String changeType = root.elementTextTrim("ChangeType");
            return doProcessContactChangeEvent(changeType, data);
        } else if (eventType.equals(EventType.click.name())) {
            MenuClickEvent message = xmlMapper.readValue(data, MenuClickEvent.class);
            return processMenuClickEvent(message);
        } else if (eventType.equals(EventType.view.name())) {
            MenuViewEvent message = xmlMapper.readValue(data, MenuViewEvent.class);
            return processMenuViewEvent(message);
        } else if (eventType.equals(EventType.scancode_push.name())) {
            ScanPushEvent message = xmlMapper.readValue(data, ScanPushEvent.class);
            return processScanPushEvent(message);
        } else if (eventType.equals(EventType.scancode_waitmsg.name())) {
            ScanWaitEvent message = xmlMapper.readValue(data, ScanWaitEvent.class);
            return processScanWaitEvent(message);
        } else if (eventType.equals(EventType.pic_sysphoto.name())) {
            PicPhoneEvent message = xmlMapper.readValue(data, PicPhoneEvent.class);
            return processPicPhoneEvent(message);
        } else if (eventType.equals(EventType.pic_photo_or_album.name())) {
            PicAlbumEvent message = xmlMapper.readValue(data, PicAlbumEvent.class);
            return processPicAlbumEvent(message);
        } else if (eventType.equals(EventType.pic_weixin.name())) {
            PicWeixinEvent message = xmlMapper.readValue(data, PicWeixinEvent.class);
            return processPicWeixinEvent(message);
        }

        throw new IllegalStateException("Event：" + eventType + "暂不支持！");
    }

    private AbstractResponseMessage processUnSubscribeEvent(UnSubscribeEvent message){
        return null;
    }

    private AbstractResponseMessage processSubscribeEvent(SubscribeEvent message) {
        return null;
    }

    /**
     * 弹出微信相册发图器的事件
     *
     * @param message
     */
    private AbstractResponseMessage processPicWeixinEvent(PicWeixinEvent message) {
        return null;
    }


    /**
     * 弹出拍照或者相册发图的事件
     *
     * @param message
     */
    private AbstractResponseMessage processPicAlbumEvent(PicAlbumEvent message) {
        return null;
    }

    /**
     * 处理弹出系统拍照发图的事件
     *
     * @param message
     */
    private AbstractResponseMessage processPicPhoneEvent(PicPhoneEvent message) {
        return null;
    }

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件
     *
     * @param message
     */
    private AbstractResponseMessage processScanWaitEvent(ScanWaitEvent message) {
        return null;
    }

    /**
     * 扫码推事件的事件
     *
     * @param message
     */
    private AbstractResponseMessage processScanPushEvent(ScanPushEvent message) {
        return null;
    }

    /**
     * 处理点击菜单跳转链接的事件
     *
     * @param message
     */
    private AbstractResponseMessage processMenuViewEvent(MenuViewEvent message) {
        return null;
    }

    /**
     * 处理菜单点击事件
     *
     * @param message
     */
    private AbstractResponseMessage processMenuClickEvent(MenuClickEvent message) {
        return null;
    }

    /**
     * 处理通讯录变更事件
     *
     * @param changeType
     * @param data
     * @throws Exception
     */
    private AbstractResponseMessage doProcessContactChangeEvent(String changeType, String data) throws Exception {
        if (StringUtils.isEmpty(changeType)) {
            throw new IllegalStateException("ChangeType 不能为空!");
        }

        if (changeType.equals(ContactChangeType.create_user.name())) {
            UserCreateEvent msg = xmlMapper.readValue(data, UserCreateEvent.class);
            return processUserCreateEvent(msg);
        } else if (changeType.equals(ContactChangeType.delete_user.name())) {
            UserDeleteEvent msg = xmlMapper.readValue(data, UserDeleteEvent.class);
            return processUserDeleteEvent(msg);
        } else if (changeType.equals(ContactChangeType.update_user.name())) {
            UserUpdateEvent msg = xmlMapper.readValue(data, UserUpdateEvent.class);
            return processUserUpdateEvent(msg);
        } else if (changeType.equals(ContactChangeType.create_party.name())) {
            PartyCreateEvent msg = xmlMapper.readValue(data, PartyCreateEvent.class);
            return processPartyCreateEvent(msg);
        } else if (changeType.equals(ContactChangeType.update_party.name())) {
            PartyUpdateEvent msg = xmlMapper.readValue(data, PartyUpdateEvent.class);
            return processPartyUpdateEvent(msg);
        } else if (changeType.equals(ContactChangeType.delete_party.name())) {
            PartyDeleteEvent msg = xmlMapper.readValue(data, PartyDeleteEvent.class);
            return processPartyDeleteEvent(msg);
        } else if (changeType.equals(ContactChangeType.update_tag.name())) {
            TagChangeEvent msg = xmlMapper.readValue(data, TagChangeEvent.class);
            return processTagChangeEvent(msg);
        }

        throw new IllegalStateException("ChangeType：" + changeType + "暂不支持！");
    }

    /**
     * 处理标签更新事件
     *
     * @param msg
     */
    private AbstractResponseMessage processTagChangeEvent(TagChangeEvent msg) {
        return null;
    }

    /**
     * 处理删除部门事件
     *
     * @param msg
     */
    private AbstractResponseMessage processPartyDeleteEvent(PartyDeleteEvent msg) {
        return null;
    }

    /**
     * 处理更新部门事件
     *
     * @param msg
     */
    private AbstractResponseMessage processPartyUpdateEvent(PartyUpdateEvent msg) {
        return null;
    }

    /**
     * 处理创建部门事件
     *
     * @param msg
     */
    private AbstractResponseMessage processPartyCreateEvent(PartyCreateEvent msg) {
        return null;
    }

    /**
     * 处理用户更新事件
     *
     * @param msg
     */
    private AbstractResponseMessage processUserUpdateEvent(UserUpdateEvent msg) {
        return null;
    }

    /**
     * 处理用户删除事件
     *
     * @param msg
     */
    private AbstractResponseMessage processUserDeleteEvent(UserDeleteEvent msg) {
        return null;
    }

    /**
     * 处理创建用户事件
     *
     * @param msg
     */
    private AbstractResponseMessage processUserCreateEvent(UserCreateEvent msg) {
        return null;
    }

    /**
     * 处理进入应用事件
     *
     * @param enterAgentEvent
     */
    public AbstractResponseMessage processEnterAgentEvent(EnterAgentEvent enterAgentEvent) {
        return null;
    }

    /**
     * 处理上报地理位置事件
     *
     * @param enterAgentEvent
     */
    public AbstractResponseMessage processLocationEvent(LocationEvent enterAgentEvent) {
        return null;
    }

    /**
     * 处理异步任务完成推送事件
     *
     * @param batchJobEvent
     */
    public AbstractResponseMessage processBatchJobResultEvent(BatchJobEvent batchJobEvent) {
        return null;
    }

}
