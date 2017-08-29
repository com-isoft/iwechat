package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.message.reception.ContactChangeType;

/**
 * 标签修改事件
 */
public class TagChangeEvent extends AbstractEventMessage {
    public TagChangeEvent() {
        this.event = EventType.change_contact;
        this.changeType = ContactChangeType.update_tag;
    }
    @JsonProperty("ChangeType")
    private ContactChangeType changeType;
    @JsonProperty("TagId")
    private int tagId;
    @JsonProperty("AddUserItems")
    private String addUserItems;
    @JsonProperty("DelUserItems")
    private String delUserItems;
    @JsonProperty("AddPartyItems")
    private String addPartyItems;
    @JsonProperty("DelPartyItems")
    private String delPartyItems;

    public ContactChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ContactChangeType changeType) {
        this.changeType = changeType;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getAddUserItems() {
        return addUserItems;
    }

    public void setAddUserItems(String addUserItems) {
        this.addUserItems = addUserItems;
    }

    public String getDelUserItems() {
        return delUserItems;
    }

    public void setDelUserItems(String delUserItems) {
        this.delUserItems = delUserItems;
    }

    public String getAddPartyItems() {
        return addPartyItems;
    }

    public void setAddPartyItems(String addPartyItems) {
        this.addPartyItems = addPartyItems;
    }

    public String getDelPartyItems() {
        return delPartyItems;
    }

    public void setDelPartyItems(String delPartyItems) {
        this.delPartyItems = delPartyItems;
    }
}
