package com.isoft.iwechat.corporation.addressbook.user.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.core.AbstractResponse;

public class UserConvertResponse extends AbstractResponse {
    @JsonProperty(value = "openid")
    private String openId;

    @JsonProperty(value = "appid")
    private String appId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
