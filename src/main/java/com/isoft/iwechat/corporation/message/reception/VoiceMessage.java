package com.isoft.iwechat.corporation.message.reception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 语音消息
 */
public class VoiceMessage extends AbstractReceptionMessage {
    public VoiceMessage(){
        this.msgType = ReceptionMessageType.voice;
    }

    /**
     * 语音媒体文件id，可以调用获取媒体文件接口拉取数据
     */
    @JsonProperty("MediaId")
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    @JsonProperty("Format")
    private String format;
    @JsonProperty("MsgId")
    private long msgId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
