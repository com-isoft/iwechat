package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 语音消息
 */
public class VoiceMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private Voice voice;

    public VoiceMessage() {
        this.msgType = TransmissionMessageType.voice;
        this.voice = new Voice();
    }

    @JsonIgnore
    public String getMediaId() {
        return this.voice.getMediaId();
    }

    public void setMediaId(String mediaId) {
        this.voice.setMediaId(mediaId);
    }


    class Voice {
        /**
         * 语音文件id，可以调用上传临时素材接口获取
         */
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
