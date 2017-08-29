package com.isoft.iwechat.corporation.message.reception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("xml")
public abstract class AbstractResponseMessage {
    /**
     * 成员UserID
     */
    @JsonProperty("ToUserName")
    private String toUserName;

    /**
     * 企业微信CorpID
     */
    @JsonProperty("FromUserName")
    private String fromUserName;

    /**
     * 消息创建时间（整型）
     */
    @JsonProperty("CreateTime")
    private int createTime;

    /**
     * 消息类型
     */
    @JsonProperty("MsgType")
    protected ResponseMessageType msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public ResponseMessageType getMsgType() {
        return msgType;
    }
}
