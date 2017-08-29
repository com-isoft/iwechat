package com.isoft.iwechat.corporation.message.reception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 视频消息
 */
public class VideoMessage extends AbstractReceptionMessage {
    public VideoMessage() {
        this.msgType = ReceptionMessageType.video;
    }

    /**
     * 视频媒体文件id，可以调用获取媒体文件接口拉取数据
     */
    @JsonProperty("MediaId")
    private String mediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据
     */
    @JsonProperty("ThumbMediaId")
    private String thumbMediaId;

    /**
     * 消息id，64位整型
     */
    @JsonProperty("MsgId")
    private long msgId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
