package com.isoft.iwechat.corporation.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationDetailInfo extends ApplicationInfo {
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
}
