package com.isoft.iwechat.corporation.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.isoft.iwechat.corporation.configuration.CorpConfig;
import com.isoft.iwechat.corporation.media.MediaManager;
import com.isoft.iwechat.corporation.media.MediaType;
import com.isoft.iwechat.corporation.message.reception.event.EnterAgentEvent;
import com.isoft.iwechat.corporation.message.reception.response.ResponseTextMessage;
import com.isoft.iwechat.corporation.message.transmission.*;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class CorpMessengerTest {
    @Autowired
    CorpMessenger messenger;

    @Autowired
    MediaManager mediaManager;

    XmlMapper mapper = new XmlMapper();

    @Test
    public void sendTextMsg() throws Exception {
        TextMessage msg = new TextMessage();
        msg.setAgentId(1000002);
        msg.setContent("测试消息");
        msg.setToUser("dlut_liuq");

        System.out.println((new ObjectMapper()).writeValueAsString(msg));

        messenger.send(msg);
    }

    @Test
    public void sendTextCardMessage() throws Exception {
        TextCardMessage msg = new TextCardMessage();
        msg.setAgentId(1000002);
        msg.setTitle("你好，这条消息是测试消息!");
        msg.setDescription("您收到请忽略哦~");
        msg.setUrl("https://www.baidu.com");
        msg.setToUser("dlut_liuq");
        msg.setBtntxt("查看详情");

        System.out.println((new ObjectMapper()).writeValueAsString(msg));
        messenger.send(msg);
    }

    @Test
    public void sendNewsMessage() throws Exception {
        NewsMessage msg = new NewsMessage();
        msg.setAgentId(1000002);
        msg.setToUser("dlut_liuq");
        msg.addNewsItem(new NewsItem("这是条测试消息", "你好！", "https://www.baidu.com", "https://www.baidu.com/img/bd_logo1.png"));

        System.out.println((new ObjectMapper()).writeValueAsString(msg));
        messenger.send(msg);
    }

    @Test
    public void sendImageMessage() throws Exception {
        String mediaId = mediaManager.upload("/Users/ltt/Downloads/sample.jpg", MediaType.image);
        ImageMessage msg = new ImageMessage();
        msg.setMediaId(mediaId);
        msg.setAgentId(1000002);
        msg.setToUser("dlut_liuq");
        msg.setMediaId(mediaId);

        messenger.send(msg);
    }

    @Test
    public void sendVideoMessage() throws Exception {
        String mediaId = mediaManager.upload("/Users/ltt/Downloads/test.mp4", MediaType.video);

        VideoMessage msg = new VideoMessage();
        msg.setMediaId(mediaId);
        msg.setAgentId(1000002);
        msg.setToUser("dlut_liuq");
        msg.setMediaId(mediaId);
        messenger.send(msg);
    }

    @Test
    public void readXmlNode() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[wxdc2be60e691f9656]]></ToUserName><FromUserName><![CDATA[dlut_liuq]]></FromUserName><CreateTime>1502673947</CreateTime><MsgType><![CDATA[event]]></MsgType><AgentID>1000002</AgentID><Event><![CDATA[enter_agent]]></Event><EventKey><![CDATA[]]></EventKey></xml>";

        Document doc = DocumentHelper.parseText(xml);
        Element root = doc.getRootElement();

        System.out.println(root.elementTextTrim("MsgType"));
    }

    @Test
    public void xmlMapper() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[wxdc2be60e691f9656]]></ToUserName><FromUserName><![CDATA[dlut_liuq]]></FromUserName><CreateTime>1502681782</CreateTime><MsgType><![CDATA[event]]></MsgType><AgentID>1000002</AgentID><Event><![CDATA[enter_agent]]></Event><EventKey><![CDATA[]]></EventKey></xml>";

        EnterAgentEvent event = mapper.readValue(xml, EnterAgentEvent.class);

        System.out.println(event.getEvent());

        ResponseTextMessage msg = new ResponseTextMessage();
        msg.setFromUserName("liuq");
        msg.setToUserName("ltt");
        msg.setCreateTime(123);
        msg.setContent("L love you!");

        System.out.println(mapper.writeValueAsString(msg));
    }
}
