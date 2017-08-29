package com.isoft.iwechat.corporation.message.transmission.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.message.transmission.AbstractTransmissionMessage;
import com.isoft.iwechat.corporation.message.transmission.CorpMessenger;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class CorpMessengerImpl implements CorpMessenger {
    private final static String BASE_URL = CorpConstant.BASE_URL + "/message";
    private final static String SEND_URL = BASE_URL + "/send";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;

    public CorpMessengerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 发送消息
     *
     * @param msg 消息
     */
    @Override
    public <T extends AbstractTransmissionMessage> void send(T msg) {
        int agentId = msg.getAgentId();
        Assert.notNull(agentId,"应用id不能为空！");

        String token =tokenManager.getToken(agentId);
        Map<String,String> variables = new HashMap<>();
        variables.put("access_token",token);

        weChatRestClient.postForObject(SEND_URL,msg,MessageResponse.class,variables);
    }
}
