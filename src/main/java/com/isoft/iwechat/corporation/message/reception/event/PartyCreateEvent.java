package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.message.reception.ContactChangeType;

/**
 * 新增部门事件
 */
public class PartyCreateEvent extends AbstractEventMessage {
    public PartyCreateEvent() {
        this.event = EventType.change_contact;
        this.changeType = ContactChangeType.create_party;
    }

    @JsonProperty("ChangeType")
    private ContactChangeType changeType;
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ParentId")
    private int parentId;
    @JsonProperty("Order")
    private int order;

    public ContactChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ContactChangeType changeType) {
        this.changeType = changeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
