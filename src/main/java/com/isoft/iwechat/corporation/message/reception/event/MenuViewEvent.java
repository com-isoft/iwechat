package com.isoft.iwechat.corporation.message.reception.event;

/**
 * 点击菜单跳转链接事件
 */
public class MenuViewEvent extends AbstractEventMessage {
    public MenuViewEvent() {
        this.event= EventType.click;
    }
}
