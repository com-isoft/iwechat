package com.isoft.iwechat.corporation.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.core.AbstractResponse;

public class ApplicationResponse extends AbstractResponse {
    /**
     * 企业应用id
     */
    @JsonProperty(value = "agentid")
    private String agentId;

    /**
     * 企业应用名称
     */
    private String name;

    /**
     * 企业应用详情
     */
    private String description;

    /**
     * 企业应用方形头像
     */
    private String squareLogoUrl;

    /**
     * 企业应用可见范围（人员），其中包括userid
     */
    @JsonProperty(value = "allow_userinfos")
    private AllowUserInfo allowUserInfo;

    /**
     * 企业应用可见范围（部门）
     */
    @JsonProperty(value = "allow_partys")
    private AllowPartyInfo allowPartyInfo;

    /**
     * 企业应用可见标签
     */
    @JsonProperty(value = "allow_tags")
    private AllowTagInfo allowTagInfo;

    /**
     * 企业应用是否被禁用
     */
    private boolean close;

    /**
     * 企业应用可信域名
     */
    private String redirectDomain;

    /**
     * 企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；
     */
    private boolean reportLocationFlag;

    /**
     * 是否上报用户进入应用事件。0：不接收；1：接收
     */
    @JsonProperty(value = "isreportenter")
    private boolean isReportenter;

    /**
     * 应用主页url
     */
    private String homeUrl;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSquareLogoUrl() {
        return squareLogoUrl;
    }

    public void setSquareLogoUrl(String squareLogoUrl) {
        this.squareLogoUrl = squareLogoUrl;
    }

    public AllowUserInfo getAllowUserInfo() {
        return allowUserInfo;
    }

    public void setAllowUserInfo(AllowUserInfo allowUserInfo) {
        this.allowUserInfo = allowUserInfo;
    }

    public AllowPartyInfo getAllowPartyInfo() {
        return allowPartyInfo;
    }

    public void setAllowPartyInfo(AllowPartyInfo allowPartyInfo) {
        this.allowPartyInfo = allowPartyInfo;
    }

    public AllowTagInfo getAllowTagInfo() {
        return allowTagInfo;
    }

    public void setAllowTagInfo(AllowTagInfo allowTagInfo) {
        this.allowTagInfo = allowTagInfo;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public String getRedirectDomain() {
        return redirectDomain;
    }

    public void setRedirectDomain(String redirectDomain) {
        this.redirectDomain = redirectDomain;
    }

    public boolean isReportLocationFlag() {
        return reportLocationFlag;
    }

    public void setReportLocationFlag(boolean reportLocationFlag) {
        this.reportLocationFlag = reportLocationFlag;
    }

    public boolean isReportenter() {
        return isReportenter;
    }

    public void setReportenter(boolean reportenter) {
        isReportenter = reportenter;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }
}
