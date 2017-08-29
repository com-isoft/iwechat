package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.message.reception.ContactChangeType;

/**
 * 删除成员事件
 */
public class UserDeleteEvent extends AbstractEventMessage {
    public UserDeleteEvent() {
        this.event = EventType.change_contact;
        this.changeType = ContactChangeType.delete_user;
    }

    @JsonProperty("ChangeType")
    private ContactChangeType changeType;
    @JsonProperty("UserId")
    private String userId;

    public ContactChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ContactChangeType changeType) {
        this.changeType = changeType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
