package com.isoft.iwechat.corporation.message.reception.event;

/**
 * 订阅事件
 */
public class SubscribeEvent extends AbstractEventMessage {
    public SubscribeEvent() {
        this.event = EventType.subscribe;
    }
}
