package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 弹出系统拍照发图的事件推送
 */
public class PicPhoneEvent extends AbstractEventMessage {
    public PicPhoneEvent() {
        this.event= EventType.pic_sysphoto;
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
