package com.isoft.iwechat.corporation.message.reception;

/**
 * 接收消息类型
 */
public enum ReceptionMessageType {
    /**
     * 事件
     */
    event,

    /**
     * 文本消息
     */
    text,

    /**
     * 图片消息
     */
    image,

    /**
     * 语音消息
     */
    voice,

    /**
     * 视频消息
     */
    video,

    /**
     * 位置消息
     */
    location,

    /**
     * 链接消息
     */
    link;
}
