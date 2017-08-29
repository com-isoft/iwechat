package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 扫码推事件且弹出“消息接收中”提示框的事件推送
 */
public class ScanWaitEvent extends AbstractEventMessage {
    public ScanWaitEvent() {
        this.event= EventType.scancode_waitmsg;
    }

    @JsonProperty("ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo;

    public ScanCodeInfo getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }
}
