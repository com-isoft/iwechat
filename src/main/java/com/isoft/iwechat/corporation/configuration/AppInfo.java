package com.isoft.iwechat.corporation.configuration;

/**
 * 应用信息
 */
public class AppInfo {
    private String name;
    private String secret;
    private int agentId;

    public AppInfo(){
    }

    public AppInfo(int agentId,String name, String secret) {
        this.name = name;
        this.secret = secret;
        this.agentId =agentId;
    }

    public String getName() {
        return name;
    }

    public String getSecret() {
        return secret;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}
