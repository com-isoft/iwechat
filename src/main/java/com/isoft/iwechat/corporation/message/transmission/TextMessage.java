package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文本消息
 */
public class TextMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private Text text;

    public TextMessage() {
        this.msgType = TransmissionMessageType.text;
        this.text = new Text();
    }

    @JsonIgnore
    public String getCountent() {
        return this.text.getContent();
    }

    public void setContent(String text) {
        this.text.setContent(text);
    }

    class Text {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
