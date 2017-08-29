package com.isoft.iwechat.corporation.addressbook.tag.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.addressbook.tag.TagInfo;
import com.isoft.iwechat.corporation.addressbook.tag.TagManager;
import com.isoft.iwechat.corporation.addressbook.tag.TagMemberInfo;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagManagerImpl implements TagManager {
    private final static String BASE_URL = CorpConstant.BASE_URL + "/tag";
    private final static String CREATE_URL = BASE_URL + "/create";
    private final static String UPDATE_URL = BASE_URL + "/update";
    private final static String DELETE_URL = BASE_URL + "/delete";
    private final static String LIST_URL = BASE_URL + "/list";
    private final static String MEMBER_LIST_URL = BASE_URL + "/get";
    private final static String ADD_MEMBER_URL = BASE_URL + "/addtagusers";
    private final static String DELETE_MEMBER_URL = BASE_URL + "/deltagusers";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;

    public TagManagerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 创建标签
     *
     * @param tagInfo 标签信息
     * @return 标签信息
     */
    @Override
    public TagInfo create(TagInfo tagInfo) {
        TagResponse response = weChatRestClient.postForObject(CREATE_URL, tagInfo, TagResponse.class, getVariables());

        tagInfo.setId(response.getTagId());
        return tagInfo;
    }

    /**
     * 更新标签名字
     *
     * @param tagInfo 标签信息
     * @return
     */
    @Override
    public TagInfo update(TagInfo tagInfo) {
        weChatRestClient.postForObject(UPDATE_URL, tagInfo, TagResponse.class, getVariables());
        return tagInfo;
    }

    /**
     * 删除标签
     *
     * @param tagId 标签id
     */
    @Override
    public void delete(Integer tagId) {
        Assert.notNull(tagId, "标签id不能为空!");

        Map<String, String> variables = this.getVariables();
        variables.put("tagid", String.valueOf(tagId));

        weChatRestClient.getForObject(DELETE_URL, TagResponse.class, variables);
    }

    /**
     * 获取标签列表
     *
     * @return 标签列表
     */
    @Override
    public List<TagInfo> list() {
        TagListResponse response = weChatRestClient.getForObject(LIST_URL, TagListResponse.class, getVariables());
        return response.getTags();
    }

    /**
     * 获取标签成员
     *
     * @param tagId 标签id
     * @return
     */
    @Override
    public TagMemberInfo member(Integer tagId) {
        Assert.notNull(tagId, "标签id不能为空!");

        Map<String, String> variables = this.getVariables();
        variables.put("tagid", String.valueOf(tagId));

        TagMemberResponse response = weChatRestClient.getForObject(MEMBER_LIST_URL, TagMemberResponse.class, variables);

        return response.toMemberInfo();
    }

    /**
     * 增加标签成员
     *
     * @param tagId     标签id
     * @param userList  企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
     * @param partyList 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
     */
    @Override
    public void addMember(Integer tagId, List<String> userList, List<Integer> partyList) {
        doPost(ADD_MEMBER_URL, tagId, userList, partyList);
    }

    /**
     * 删除标签成员
     *
     * @param userList  企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
     * @param partyList 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
     */
    @Override
    public void deleteMember(Integer tagId, List<String> userList, List<Integer> partyList) {
        doPost(DELETE_MEMBER_URL, tagId, userList, partyList);
    }

    private void doPost(String url, Integer tagId, List<String> userList, List<Integer> partyList) {
        Assert.notNull(tagId, "标签id不能为空!");

        if (userList == null && partyList == null) {
            throw new IllegalArgumentException("userlist、partylist不能同时为空！");
        }

        Map<String, Object> data = new HashMap<>();
        data.put("tagid", String.valueOf(tagId));
        data.put("userlist", userList);
        data.put("partylist", partyList);

        weChatRestClient.postForObject(url, data, TagResponse.class, getVariables());
    }

    private Map<String, String> getVariables() {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(CorpConstant.ADDRESS_BOOK_AGENT_ID));

        return variables;
    }
}
