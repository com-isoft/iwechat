package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 视频消息
 */
public class VideoMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private Video video;

    public VideoMessage(){
        this.msgType = TransmissionMessageType.video;
        this.video = new Video();
    }

    @JsonIgnore
    public String getMediaId() {
        return this.video.getMediaId();
    }

    public void setMediaId(String mediaId) {
        this.video.setMediaId(mediaId);
    }

    @JsonIgnore
    public String getTitle() {
        return this.video.getTitle();
    }

    public void setTitle(String title) {
        this.video.setTitle(title);
    }

    @JsonIgnore
    public String getDescription() {
        return this.video.getDescription();
    }

    public void setDescription(String description) {
        this.video.setDescription(description);
    }

    class Video{
        /**
         * 视频媒体文件id，可以调用上传临时素材接口获取
         */
        private String mediaId;

        /**
         * 视频消息的标题，不超过128个字节，超过会自动截断
         */
        private String title;

        /**
         * 视频消息的描述，不超过512个字节，超过会自动截断
         */
        private String description;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
