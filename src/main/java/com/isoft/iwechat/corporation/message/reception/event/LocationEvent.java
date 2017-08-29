package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 上报地理位置
 */
public class LocationEvent extends AbstractEventMessage {
    public LocationEvent() {
        this.event = EventType.LOCATION;
    }

    /**
     * 地理位置纬度
     */
    @JsonProperty("Latitude")
    private double latitude;

    /**
     * 地理位置经度
     */
    @JsonProperty("Longitude")
    private double longitude;

    /**
     * 地理位置精度
     */
    @JsonProperty("Precision")
    private double precision;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }
}
