package com.isoft.iwechat.core;

/**
 * token manager
 */
public interface TokenManager {
    /**
     * 获取access token，token过期后自动获取新的token
     * @param agentId 应用id
     * @return
     */
    String getToken(int agentId);
}
