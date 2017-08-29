package com.isoft.iwechat.corporation.addressbook.user.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.addressbook.user.UserInfo;
import com.isoft.iwechat.corporation.addressbook.user.UserManager;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagerImpl implements UserManager {
    private final static String BASE_URL = CorpConstant.BASE_URL + "/user";
    private final static String CREATE_URL = BASE_URL + "/create";
    private final static String GET_URL = BASE_URL + "/get";
    private final static String UPDATE_URL = BASE_URL + "/update";
    private final static String DELETE_URL = BASE_URL + "/delete";
    private final static String BATCH_DELETE_URL = BASE_URL + "/batchdelete";
    private final static String LIST_URL = BASE_URL + "/list";
    private final static String SIMPLE_LIST_URL = BASE_URL + "/simplelist";
    private final static String CONVERT_URL = BASE_URL + "/convert_to_openid";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;

    public UserManagerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 创建成员
     *
     * @param userInfo 成员信息
     * @return 成员信息
     */
    @Override
    public UserInfo create(UserInfo userInfo) {
        this.weChatRestClient.postForObject(CREATE_URL, userInfo, UserResponse.class, getVariables());

        return userInfo;
    }

    /**
     * 读取成员
     *
     * @param userId 成员id
     * @return 成员信息
     */
    @Override
    public UserInfo get(String userId) {
        Assert.notNull(userId, "成员id不能为空!");

        Map<String, String> variables = getVariables();
        variables.put("userid", userId);

        UserResponse response = this.weChatRestClient.getForObject(GET_URL, UserResponse.class, variables);

        return response.toUserInfo();
    }

    /**
     * 更新成员
     *
     * @param userInfo 成员信息
     * @return 成员信息
     */
    @Override
    public UserInfo update(UserInfo userInfo) {
        this.weChatRestClient.postForObject(UPDATE_URL, userInfo, UserResponse.class, getVariables());

        return userInfo;
    }

    /**
     * 删除成员
     *
     * @param userId 成员id
     */
    @Override
    public void delete(String userId) {
        Assert.notNull(userId, "成员id不能为空!");

        Map<String, String> variables = getVariables();
        variables.put("userid", userId);
        this.weChatRestClient.getForObject(DELETE_URL, UserResponse.class, variables);
    }

    /**
     * 批量删除成员
     *
     * @param userIds 成员id集合
     */
    @Override
    public void batchDelete(List<String> userIds) {
        Assert.notEmpty(userIds, "成员id集合不能为空");
        Map<String, List<String>> data = new HashMap<>();
        data.put("useridlist", userIds);

        this.weChatRestClient.postForObject(BATCH_DELETE_URL, data, UserResponse.class, getVariables());
    }

    /**
     * 获取部门成员简要信息
     *
     * @param departmentId 部门id
     * @param fetchChild   是否递归获取子部门下面的成员
     * @return 成员集合
     */
    @Override
    public List<UserInfo> simpleist(Integer departmentId, boolean fetchChild) {
        return doList(SIMPLE_LIST_URL, departmentId, fetchChild);
    }

    /**
     * 获取部门成员详细信息
     *
     * @param departmentId 部门id
     * @param fetchChild   是否递归获取子部门下面的成员
     * @return 成员集合
     */
    @Override
    public List<UserInfo> list(Integer departmentId, boolean fetchChild) {
        return doList(LIST_URL, departmentId, fetchChild);
    }

    /**
     * userid转换成openid
     * 该接口使用场景为微信支付、微信红包和企业转账，企业号用户在使用微信支付的功能时，需要自行将企业号的userid转成openid。在使用微信红包功能时，需要将应用id和userid转成appid和openid才能使用。
     *
     * @param userId  企业内的成员id
     * @param agentId 整型，需要发送红包的应用ID，若只是使用微信支付和企业转账，则无需该参数
     * @return
     */
    @Override
    public String convertToOpenId(String userId, Integer agentId) {
        Assert.notNull(userId, "成员id不能为空！");
        Map<String, String> data = new HashMap<>();

        data.put("userid", userId);

        if(agentId!=null) {
            data.put("agentid", String.valueOf(agentId));
        }

        UserConvertResponse response = this.weChatRestClient.postForObject(CONVERT_URL, data, UserConvertResponse.class, getVariables());
        return response.getAppId();
    }

    private Map<String, String> getVariables() {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(CorpConstant.ADDRESS_BOOK_AGENT_ID));

        return variables;
    }

    private List<UserInfo> doList(String url, Integer departmentId, boolean fetchChild) {
        Assert.notNull(departmentId, "部门id不能为空！");

        Map<String, String> variables = getVariables();
        variables.put("department_id", String.valueOf(departmentId));
        variables.put("fetch_child", fetchChild ? "1" : "0");

        UserListResponse response = this.weChatRestClient.getForObject(url, UserListResponse.class, variables);
        return response.getUserlist();
    }
}
