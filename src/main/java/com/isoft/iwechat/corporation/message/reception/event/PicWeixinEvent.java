package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 弹出微信相册发图器的事件推送
 */
public class PicWeixinEvent extends AbstractEventMessage {
    public PicWeixinEvent() {
        this.event= EventType.pic_weixin;
    }

    @JsonProperty("SendPicsInfo")
    private SendPicsInfo sendPicsInfo;

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }
}
