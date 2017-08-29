package com.isoft.iwechat.corporation.message.reception.event;

/**
 * 进入应用
 */
public class EnterAgentEvent extends AbstractEventMessage {
    public EnterAgentEvent(){
        this.event = EventType.enter_agent;
    }
}
