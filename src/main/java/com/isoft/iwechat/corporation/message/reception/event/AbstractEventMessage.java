package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.message.reception.AbstractReceptionMessage;

public abstract class AbstractEventMessage extends AbstractReceptionMessage {
    /**
     * 事件类型
     */
    @JsonProperty("Event")
    protected EventType event;

    /**
     * 事件KEY值，此事件该值为空
     */
    @JsonProperty("EventKey")
    private String eventKey;

    public EventType getEvent() {
        return event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
