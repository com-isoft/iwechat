package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件消息
 */
public class FileMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private File file;

    public FileMessage(){
        this.msgType = TransmissionMessageType.file;
        this.file =new File();
    }

    @JsonIgnore
    public String getMediaId() {
        return this.file.getMediaId();
    }

    public void setMediaId(String mediaId) {
        this.file.setMediaId(mediaId);
    }

    class File{
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
