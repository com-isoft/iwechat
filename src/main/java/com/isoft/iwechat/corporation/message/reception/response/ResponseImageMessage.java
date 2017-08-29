package com.isoft.iwechat.corporation.message.reception.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 图片消息
 */
public class ResponseImageMessage extends AbstractResponseMessage {
    @JsonProperty("Image")
    private Image image;

    public ResponseImageMessage() {
        this.msgType = ResponseMessageType.image.image;
        this.image = new Image();
    }

    @JsonIgnore
    public String getMediaId() {
        return this.image.getMediaId();
    }

    public void setMediaId(String mediaId) {
        this.image.setMediaId(mediaId);
    }


    class Image {
        @JsonProperty("MediaId")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
