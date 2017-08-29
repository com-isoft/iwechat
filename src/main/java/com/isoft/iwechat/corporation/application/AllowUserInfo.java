package com.isoft.iwechat.corporation.application;

import com.isoft.iwechat.corporation.addressbook.user.UserInfo;

import java.util.List;

public class AllowUserInfo {
    private List<UserInfo> user;

    public List<UserInfo> getUser() {
        return user;
    }

    public void setUser(List<UserInfo> user) {
        this.user = user;
    }
}
