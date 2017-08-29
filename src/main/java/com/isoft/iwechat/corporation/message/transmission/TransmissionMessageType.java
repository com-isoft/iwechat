package com.isoft.iwechat.corporation.message.transmission;

public enum TransmissionMessageType {
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
     * 文件消息
     */
    file,

    /**
     * 文本卡片消息
     */
    textcard,

    /**
     * 图文消息
     */
    news,

    /**
     * 图文消息
     * mpnews类型的图文消息，跟普通的图文消息在客户端表现上是一致的。
     * mpnews可以通过管理后台的“管理工具” - “消息群发助手”来发送，也可以通过以下描述的API接口，通过企业自己的平台进行发送。
     */
    mpnews
}
