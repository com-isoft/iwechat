package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractTransmissionMessage {
    /**
     * 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送
     */
    @JsonProperty(value = "touser")
    protected String toUser;

    /**
     * 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    @JsonProperty(value = "toparty")
    protected String toParty;

    /**
     * 标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    @JsonProperty(value = "totag")
    protected String toTag;

    /**
     * 消息类型
     */
    @JsonProperty(value = "msgtype")
    protected TransmissionMessageType msgType;

    /**
     * 企业应用的id，整型。可在应用的设置页面查看
     */
    @JsonProperty(value = "agentid")
    protected int agentId;

    /**
     * 表示是否是保密消息，0表示否，1表示是，默认0
     */
    protected int safe =0;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getToParty() {
        return toParty;
    }

    public void setToParty(String toParty) {
        this.toParty = toParty;
    }

    public String getToTag() {
        return toTag;
    }

    public void setToTag(String toTag) {
        this.toTag = toTag;
    }

    public TransmissionMessageType getMsgType() {
        return msgType;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
