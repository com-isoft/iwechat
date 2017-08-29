package com.isoft.iwechat.core.impl;

import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.core.RequestFailedException;
import com.isoft.iwechat.core.WeChatRestClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WeChatRestClientImpl implements WeChatRestClient {
    private RestTemplate restTemplate;

    public WeChatRestClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T extends AbstractResponse> T getForObject(String url, Class<T> responseType, Map<String, String> uriVariables) {
        T response = this.restTemplate.getForObject(appendUriVariables(url, uriVariables), responseType, uriVariables);
        checkResponse(response);
        return response;
    }

    @Override
    public <T extends AbstractResponse> T postForObject(String url, Object request, Class<T> responseType, Map<String, String> uriVariables) {
        T response = this.restTemplate.postForObject(appendUriVariables(url, uriVariables), request, responseType, uriVariables);
        checkResponse(response);
        return response;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, String> uriVariables) {
        return this.restTemplate.exchange(appendUriVariables(url, uriVariables)
                , method
                , requestEntity
                , responseType
                , uriVariables);
    }

    private void checkResponse(AbstractResponse response) {
        if (response.getErrcode() != 0) {
            throw new RequestFailedException(response.getErrcode(), response.getErrmsg());
        }
    }

    private String appendUriVariables(String url, Map<String, String> uriVariables) {
        StringBuilder builder = new StringBuilder();
        builder.append(url);

        if (url.indexOf("?") < 0) {
            builder.append("?");
        }

        for (String key : uriVariables.keySet()) {
            builder.append(key + "={" + key + "}&");
        }

        return builder.substring(0, builder.length() - 1);
    }
}
