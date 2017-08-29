package com.isoft.iwechat.corporation.message.reception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 链接消息
 */
public class LinkMessage extends AbstractReceptionMessage {
    public LinkMessage(){
        this.msgType =ReceptionMessageType.link;
    }
    /**
     * 标题
     */
    @JsonProperty("Title")
    private String title;

    /**
     * 描述
     */
    @JsonProperty("Description")
    private String description;

    /**
     * 封面缩略图的url
     */
    @JsonProperty("PicUrl")
    private String picUrl;

    /**
     * 消息id，64位整型
     */
    @JsonProperty("MsgId")
    private long msgId;

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
