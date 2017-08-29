package com.isoft.iwechat.corporation.message.reception.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文本消息
 */

public class ResponseTextMessage extends AbstractResponseMessage {

    public ResponseTextMessage(){
        this.msgType = ResponseMessageType.text;
    }

    @JsonProperty("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
