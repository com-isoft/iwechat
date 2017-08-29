package com.isoft.iwechat.corporation.oa;

public class CheckInInfo {
    /**
     * 用户id
     */
    private String userid;

    /**
     * 打卡规则名称
     */
    private String groupname;

    /**
     * 打卡类型
     */
    private String checkinType;

    /**
     * 异常类型，如果有多个异常，以分号间隔
     */
    private String exceptionType;

    /**
     * 打卡时间。UTC时间戳
     */
    private long checkinTime;

    /**
     * 打卡地点title
     */
    private String locationTitle;

    /**
     * 打卡地点详情
     */
    private String locationDetail;

    /**
     * 打卡wifi名称
     */
    private String wifiname;

    /**
     * 打卡备注
     */
    private String notes;

    /**
     * 打卡的MAC地址/bssid
     */
    private String wifimac;

    /**
     * 打卡的附件media_id，可使用media/get获取附件
     */
    private String mediaids;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCheckinType() {
        return checkinType;
    }

    public void setCheckinType(String checkinType) {
        this.checkinType = checkinType;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public long getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(long checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public String getWifiname() {
        return wifiname;
    }

    public void setWifiname(String wifiname) {
        this.wifiname = wifiname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getWifimac() {
        return wifimac;
    }

    public void setWifimac(String wifimac) {
        this.wifimac = wifimac;
    }

    public String getMediaids() {
        return mediaids;
    }

    public void setMediaids(String mediaids) {
        this.mediaids = mediaids;
    }
}
