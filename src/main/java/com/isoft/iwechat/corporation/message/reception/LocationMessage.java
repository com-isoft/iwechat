package com.isoft.iwechat.corporation.message.reception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 位置消息
 */
public class LocationMessage extends AbstractReceptionMessage {
    public LocationMessage() {
        this.msgType =ReceptionMessageType.location;
    }

    /**
     * 地理位置纬度
     */
    @JsonProperty("Location_X")
    private Double location_X;

    /**
     * 地理位置经度
     */
    @JsonProperty("Location_Y")
    private Double location_Y;

    /**
     * 地图缩放大小
     */
    @JsonProperty("Scale")
    private int scale;

    /**
     * 地理位置信息
     */
    @JsonProperty("Label")
    private String label;

    /**
     * 消息id，64位整型
     */
    @JsonProperty("MsgId")
    private long msgId;

    public Double getLocation_X() {
        return location_X;
    }

    public void setLocation_X(Double location_X) {
        this.location_X = location_X;
    }

    public Double getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(Double location_Y) {
        this.location_Y = location_Y;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
