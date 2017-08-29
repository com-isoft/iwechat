package com.isoft.iwechat.corporation.application.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.application.ApplicationInfo;

import java.util.List;

public class ApplicationListResponse extends AbstractResponse {
    @JsonProperty(value = "agentlist")
    private List<ApplicationInfo> apps;

    public List<ApplicationInfo> getApps() {
        return apps;
    }

    public void setApps(List<ApplicationInfo> apps) {
        this.apps = apps;
    }
}
