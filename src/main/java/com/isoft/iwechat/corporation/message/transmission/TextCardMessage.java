package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文本卡片消息
 */
public class TextCardMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private TextCard textcard;

    public TextCardMessage(){
        this.msgType = TransmissionMessageType.textcard;
        this.textcard = new TextCard();
    }

    @JsonIgnore
    public String getTitle() {
        return this.textcard.getTitle();
    }

    public void setTitle(String title) {
        this.textcard.setTitle(title);
    }

    @JsonIgnore
    public String getDescription() {
        return this.textcard.getDescription();
    }

    public void setDescription(String description) {
        this.textcard.setDescription(description);
    }

    @JsonIgnore
    public String getUrl() {
        return this.textcard.getUrl();
    }

    public void setUrl(String url) {
        this.textcard.setUrl(url);
    }

    @JsonIgnore
    public String getBtntxt() {
        return this.textcard.getBtntxt();
    }

    public void setBtntxt(String btntxt) {
        this.textcard.setBtntxt(btntxt);
    }

    class TextCard{
        /**
         * 标题，不超过128个字节，超过会自动截断
         */
        private String title;

        /**
         * 描述，不超过512个字节，超过会自动截断
         */
        private String description;

        /**
         * 点击后跳转的链接
         */
        private String url;

        /**
         * 按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断
         */
        private String btntxt = "详情";

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBtntxt() {
            return btntxt;
        }

        public void setBtntxt(String btntxt) {
            this.btntxt = btntxt;
        }
    }
}
