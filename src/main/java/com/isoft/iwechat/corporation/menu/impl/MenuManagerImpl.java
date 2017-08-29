package com.isoft.iwechat.corporation.menu.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.menu.Button;
import com.isoft.iwechat.corporation.menu.MenuButton;
import com.isoft.iwechat.corporation.menu.MenuManager;

import java.util.HashMap;
import java.util.Map;

public class MenuManagerImpl implements MenuManager {
    private final static String BASE_URL = CorpConstant.BASE_URL + "/menu";
    private final static String CREATE_URL = BASE_URL + "/create";
    private final static String DELETE_URL = BASE_URL + "/delete";
    private final static String GET_URL = BASE_URL + "/get";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;


    public MenuManagerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 创建菜单
     *
     * @param button  菜单
     * @param agentId 企业应用的id
     * @return 菜单
     */
    @Override
    public MenuButton create(int agentId,MenuButton button) {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(agentId));
        variables.put("agentid", String.valueOf(agentId));

        weChatRestClient.postForObject(CREATE_URL,button,MenuResponse.class,variables);

        return button;
    }

    /**
     * 获取菜单
     *
     * @param agentId 企业应用的id
     * @return 菜单
     */
    @Override
    public MenuButton get(int agentId) {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(agentId));
        variables.put("agentid", String.valueOf(agentId));

        MenuResponse response =weChatRestClient.getForObject(GET_URL,MenuResponse.class,variables);

        MenuButton menuButton = new MenuButton();

        for (Button btn: response.getButton()){
            menuButton.addButton(btn);
        }

        return menuButton;
    }

    /**
     * 删除菜单
     *
     * @param agentId 企业应用的id
     */
    @Override
    public void delete(int agentId) {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(agentId));
        variables.put("agentid", String.valueOf(agentId));

        weChatRestClient.getForObject(DELETE_URL,MenuResponse.class,variables);
    }
}
