package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private Image image;

    public ImageMessage() {
        this.msgType = TransmissionMessageType.image;
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
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
