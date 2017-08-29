package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 弹出地理位置选择器的事件推送
 */
public class LocationSelectEvent extends AbstractEventMessage {
    public LocationSelectEvent() {
        this.event = EventType.location_select;
    }

    @JsonProperty("SendLocationInfo")
    private SendLocationInfo sendLocationInfo;

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }

    class SendLocationInfo{
        @JsonProperty("Location_X")
        private double location_X;
        @JsonProperty("Location_Y")
        private double location_Y;
        @JsonProperty("Scale")
        private int scale;
        @JsonProperty("Label")
        private String label;
        @JsonProperty("Poiname")
        private String poiname;

        public double getLocation_X() {
            return location_X;
        }

        public void setLocation_X(double location_X) {
            this.location_X = location_X;
        }

        public double getLocation_Y() {
            return location_Y;
        }

        public void setLocation_Y(double location_Y) {
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

        public String getPoiname() {
            return poiname;
        }

        public void setPoiname(String poiname) {
            this.poiname = poiname;
        }
    }
}
