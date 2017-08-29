package com.isoft.iwechat.corporation.menu;

public enum ButtonType {
    /**
     * 菜单事件
     * 成员点击click类型按钮后，企业微信服务器会通过消息接口推送消息类型为event 的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与成员进行交互；
     */
    click,

    /**
     * 菜单view事件
     * 成员点击view类型按钮后，企业微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取成员基本信息接口结合，获得成员基本信息
     */
    view,

    /**
     * 扫码推事件
     * 成员点击按钮后，企业微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可用于下发消息。
     */
    scancode_push,

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     * 成员点击按钮后，企业微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
     */
    scancode_waitmsg,

    /**
     * 弹出系统拍照发图的事件推送
     * 弹出系统拍照发图 成员点击按钮后，企业微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
     */
    pic_sysphoto,

    /**
     * 弹出拍照或者相册发图的事件推送
     * 成员点击按钮后，企业微信客户端将调起企业微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
     */
    pic_photo_or_album,

    /**
     * 弹出微信相册发图器的事件推送
     * 成员点击按钮后，企业微信客户端将调起企业微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
     */
    pic_weixin,

    /**
     * 弹出地理位置选择器的事件推送
     * 成员点击按钮后，企业微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
     */
    location_select
}