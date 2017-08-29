package com.isoft.iwechat.core;

import java.util.Date;

public class TokenInfo {
    private String corpId;
    private String corpSecret;
    private String token;
    private Date createdOn;
    private int expiresIn;

    public TokenInfo(String corpId, String corpSecret, String token, int expiresIn) {
        this.corpId = corpId;
        this.corpSecret = corpSecret;
        this.token = token;
        this.expiresIn = expiresIn;
        this.createdOn = new Date();
    }

    public TokenInfo(String corpId, String corpSecret, String token, int expiresIn, Date createdOn) {
        this(corpId, corpSecret, token, expiresIn);
        this.createdOn = createdOn;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getCorpSecret() {
        return corpSecret;
    }

    public String getToken() {
        return token;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public boolean isExpired() {
        boolean isExpired = false;
        int hold = (this.getExpiresIn() - 60) * 1000;

        if ((new Date()).getTime() - this.getCreatedOn().getTime() > hold) {
            isExpired = true;
        }

        return isExpired;
    }
}
