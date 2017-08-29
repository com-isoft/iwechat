package com.isoft.iwechat.corporation.application.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.application.ApplicationDetailInfo;
import com.isoft.iwechat.corporation.application.ApplicationInfo;
import com.isoft.iwechat.corporation.application.ApplicationManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationMangerImpl implements ApplicationManager {
    private final static String BASE_URL = CorpConstant.BASE_URL + "/agent";
    private final static String GET_URL = BASE_URL + "/get";
    private final static String SET_URL = BASE_URL + "/set";
    private final static String LIST_URL = BASE_URL + "/list";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;

    public ApplicationMangerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 获取应用信息
     *
     * @param agentId 应用id
     * @return 应用信息
     */
    @Override
    public ApplicationDetailInfo get(int agentId) {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", getToken(agentId));
        variables.put("agentid", String.valueOf(agentId));

        ApplicationDetailResponse response = weChatRestClient.getForObject(GET_URL, ApplicationDetailResponse.class, variables);

        return response.toApplicationDetailInfo();
    }

    /**
     * 设置应用信息
     *
     * @param applicationInfo 应用信息
     */
    @Override
    public void set(ApplicationInfo applicationInfo) {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", getToken(applicationInfo.getAgentId()));

        weChatRestClient.postForObject(SET_URL, applicationInfo, ApplicationDetailResponse.class, variables);
    }

    /**
     * 获取应用概况列表
     *
     * @return 应用概况及和
     */
    @Override
    public List<ApplicationInfo> list(int agentId) {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", getToken(agentId));

        ApplicationListResponse response = weChatRestClient.getForObject(LIST_URL,ApplicationListResponse.class,variables);

        return response.getApps();
    }

    private String getToken(int agentId) {
        return tokenManager.getToken(agentId);
    }
}
