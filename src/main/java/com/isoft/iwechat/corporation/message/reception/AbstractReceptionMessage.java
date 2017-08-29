package com.isoft.iwechat.corporation.message.reception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("xml")
public class AbstractReceptionMessage {
    /**
     * 企业微信CorpID
     */
    @JsonProperty("ToUserName")
    private String toUserName;

    /**
     * 成员UserID
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
    protected ReceptionMessageType msgType;

    /**
     * 应用id
     */
    @JsonProperty("AgentID")
    private int agentId;

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

    public ReceptionMessageType getMsgType() {
        return msgType;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}
