package com.isoft.iwechat.corporation.addressbook.user.impl;

import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.addressbook.user.UserInfo;

import java.util.List;

public class UserListResponse extends AbstractResponse {
    public List<UserInfo> userlist;

    public List<UserInfo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserInfo> userlist) {
        this.userlist = userlist;
    }
}
