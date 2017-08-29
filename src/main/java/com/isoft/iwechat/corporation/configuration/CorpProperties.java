package com.isoft.iwechat.corporation.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

import static com.isoft.iwechat.corporation.CorpConstant.*;

@ConfigurationProperties(prefix = "isoft.iwechat.corporation")
public class CorpProperties {
    private String corpId;
    private String corpToken;
    private String corpKey;
    private String addressBookSecret;
    private List<AppInfo> apps;

    public CorpProperties() {
        apps = new ArrayList<>();
    }

    public String getCorpId() {
        return corpId;
    }

    public List<AppInfo> getApps() {
        return apps;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setApps(List<AppInfo> apps) {
        this.apps = apps;
    }

    public AppInfo getAppInfo(int agentId) {
        if(agentId == ADDRESS_BOOK_AGENT_ID){
            return new AppInfo(ADDRESS_BOOK_AGENT_ID,ADDRESS_BOOK_NAME,addressBookSecret);
        }

        for (AppInfo app : this.getApps()) {
            if (app.getAgentId() == agentId) {
                return app;
            }
        }
        throw new IllegalArgumentException("输入的agentid不存在！");
    }

    public String getAddressBookSecret() {
        return addressBookSecret;
    }

    public void setAddressBookSecret(String addressBookSecret) {
        this.addressBookSecret = addressBookSecret;
    }

    public String getCorpToken() {
        return corpToken;
    }

    public void setCorpToken(String corpToken) {
        this.corpToken = corpToken;
    }

    public String getCorpKey() {
        return corpKey;
    }

    public void setCorpKey(String corpKey) {
        this.corpKey = corpKey;
    }
}


