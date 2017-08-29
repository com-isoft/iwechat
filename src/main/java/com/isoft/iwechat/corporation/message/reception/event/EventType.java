package com.isoft.iwechat.corporation.message.reception.event;

public enum EventType {
    /**
     * 订阅
     */
    subscribe,

    /**
     * 取消订阅
     */
    unsubscribe,

    /**
     * 进入应用
     */
    enter_agent,

    /**
     * 上报地理位置
     */
    LOCATION,

    /**
     * 异步任务完成事件推送
     */
    batch_job_result,

    /**
     * 通讯录变更事件
     */
    change_contact,
    /**
     * 菜单事件
     */
    click,

    /**
     * 点击菜单跳转链接的事件推送
     */
    view,

    /**
     * 扫码推事件的事件推送
     */
    scancode_push,

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     */
    scancode_waitmsg,

    /**
     * 弹出系统拍照发图的事件推送
     */
    pic_sysphoto,

    /**
     * 弹出拍照或者相册发图的事件推送
     */
    pic_photo_or_album,

    /**
     * 弹出微信相册发图器的事件推送
     */
    pic_weixin,

    /**
     * 弹出地理位置选择器的事件推送
     */
    location_select
}
