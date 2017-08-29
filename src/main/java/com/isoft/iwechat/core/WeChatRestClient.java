package com.isoft.iwechat.core;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface WeChatRestClient {
    <T extends AbstractResponse> T getForObject(String url, Class<T> responseType, Map<String, String> uriVariables);
    <T extends AbstractResponse> T postForObject(String url, Object request, Class<T> responseType, Map<String, String> uriVariables);
    <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
                                   Class<T> responseType, Map<String, String> uriVariables);
}
