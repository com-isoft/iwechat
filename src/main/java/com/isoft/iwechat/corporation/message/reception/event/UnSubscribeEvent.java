package com.isoft.iwechat.corporation.message.reception.event;

/**
 * 取消订阅事件
 */
public class UnSubscribeEvent extends AbstractEventMessage {
    public UnSubscribeEvent() {
        this.event = EventType.unsubscribe;
    }
}
