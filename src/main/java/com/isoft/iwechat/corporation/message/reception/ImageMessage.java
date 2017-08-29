package com.isoft.iwechat.corporation.message.reception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 图片消息
 */
public class ImageMessage extends AbstractReceptionMessage {
    public ImageMessage() {
        this.msgType = ReceptionMessageType.image;
    }

    /**
     * 图片链接
     */
    @JsonProperty("PicUrl")
    private String picUrl;

    /**
     * 图片媒体文件id，可以调用获取媒体文件接口拉取
     */
    @JsonProperty("MediaId")
    private String mediaId;

    /**
     * 消息id，64位整型
     */
    @JsonProperty("MsgId")
    private long msgId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
