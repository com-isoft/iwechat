package com.isoft.iwechat.corporation.message.reception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文本推送消息
 */
public class TextMessage extends AbstractReceptionMessage {
    public TextMessage(){
        this.msgType= ReceptionMessageType.text;
    }
    /**
     * 文本消息内容
     */
    @JsonProperty("Content")
    private String content;

    /**
     * 消息id，64位整型
     */
    @JsonProperty("MsgId")
    private long msgId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
