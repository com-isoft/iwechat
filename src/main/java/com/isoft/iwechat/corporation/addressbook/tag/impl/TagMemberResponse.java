package com.isoft.iwechat.corporation.addressbook.tag.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.addressbook.tag.TagMemberInfo;
import com.isoft.iwechat.corporation.addressbook.user.UserInfo;

import java.util.List;

public class TagMemberResponse extends AbstractResponse {
    /**
     * 标签名称
     */
    @JsonProperty(value = "tagname")
    private String tagName;

    /**
     * 用户列表
     */
    @JsonProperty(value = "userlist")
    private List<UserInfo> userList;

    /**
     * 部门列表
     */
    @JsonProperty(value = "partylist")
    private List<Integer> partyList;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

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

    public TagMemberInfo toMemberInfo(){
        TagMemberInfo memberInfo = new TagMemberInfo();
        memberInfo.setUserList(getUserList());
        memberInfo.setPartyList(getPartyList());

        return memberInfo;
    }
}

