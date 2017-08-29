package com.isoft.iwechat.corporation.addressbook.tag;

import com.isoft.iwechat.corporation.addressbook.user.UserInfo;

import java.util.List;

public class TagMemberInfo {
    /**
     * 用户列表
     */
    private List<UserInfo> userList;

    /**
     * 部门列表
     */
    private List<Integer> partyList;

    public List<UserInfo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserInfo> userList) {
        this.userList = userList;
    }

    public List<Integer> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<Integer> partyList) {
        this.partyList = partyList;
    }
}
