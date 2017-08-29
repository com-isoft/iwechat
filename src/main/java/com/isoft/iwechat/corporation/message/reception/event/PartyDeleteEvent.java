package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.message.reception.ContactChangeType;

public class PartyDeleteEvent extends AbstractEventMessage {
    public PartyDeleteEvent() {
        this.event = EventType.change_contact;
        this.changeType = ContactChangeType.delete_party;
    }

    @JsonProperty("ChangeType")
    private ContactChangeType changeType;
    @JsonProperty("Id")
    private int id;

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
}
