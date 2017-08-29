package com.isoft.iwechat.corporation.message.reception.event;

/**
 * 菜单点击事件
 */
public class MenuClickEvent extends AbstractEventMessage {
    public MenuClickEvent() {
        this.event= EventType.click;
    }
}
