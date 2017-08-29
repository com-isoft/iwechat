package com.isoft.iwechat.core.impl;

import com.isoft.iwechat.core.TokenInfo;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.corporation.configuration.AppInfo;
import com.isoft.iwechat.corporation.configuration.CorpProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TokenManagerImpl implements TokenManager {
    private static final String URL= CorpConstant.BASE_URL + "/gettoken";

    private WeChatRestClient weChatRestClient;
    private CorpProperties corpProperties;

    private static ConcurrentHashMap<Integer,TokenInfo> tokenCache;
    private static ConcurrentHashMap<Integer,Object> syncLock;

    static {
        tokenCache = new ConcurrentHashMap<>();
        syncLock = new ConcurrentHashMap<>();
    }

    public TokenManagerImpl(WeChatRestClient weChatRestClient, CorpProperties corpProperties){
        this.weChatRestClient = weChatRestClient;
        this.corpProperties = corpProperties;
    }

    /**
     * 获取access token，token过期后自动获取新的token
     *
     * @param agentId 应用id
     * @return
     */
    @Override
    public String getToken(int agentId) {
        AppInfo app = this.corpProperties.getAppInfo(agentId);

        syncLock.putIfAbsent(agentId,new Object());

        TokenInfo tokenInfo;

        synchronized (syncLock.get(agentId)) {
            if (!tokenCache.containsKey(agentId)) {
                tokenInfo = getTokenInfo(getCorpId(), app.getSecret());
                tokenCache.put(agentId, tokenInfo);
            } else {
                tokenInfo = tokenCache.get(agentId);

                if (tokenInfo.isExpired()) {
                    tokenInfo = getTokenInfo(getCorpId(), app.getSecret());
                    tokenCache.put(agentId, tokenInfo);
                }
            }
        }

        return tokenInfo.getToken();
    }

    private TokenInfo getTokenInfo(String corpId, String corpSecret){
        Map<String,String> variables = new HashMap<>();
        variables.put("corpid",corpId);
        variables.put("corpsecret", corpSecret);

        TokenResponse response = weChatRestClient.getForObject(URL, TokenResponse.class, variables);

        return new TokenInfo(corpId,corpSecret,response.getAccessToken(),response.getExpiresIn());
    }

    private String getCorpId() {
        return this.corpProperties.getCorpId();
    }
}
