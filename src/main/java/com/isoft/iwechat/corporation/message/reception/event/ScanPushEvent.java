package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 扫码推事件的事件推送
 */
public class ScanPushEvent extends AbstractEventMessage {
    public ScanPushEvent() {
        this.event= EventType.scancode_push;
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
