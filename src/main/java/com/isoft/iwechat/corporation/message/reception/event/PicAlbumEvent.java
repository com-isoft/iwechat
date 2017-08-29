package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 弹出拍照或者相册发图的事件推送
 */
public class PicAlbumEvent extends AbstractEventMessage {
    public PicAlbumEvent() {
        this.event= EventType.pic_photo_or_album;
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
