package com.isoft.iwechat.corporation.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.core.impl.TokenManagerImpl;
import com.isoft.iwechat.core.impl.WeChatRestClientImpl;
import com.isoft.iwechat.corporation.addressbook.department.DepartmentManager;
import com.isoft.iwechat.corporation.addressbook.department.impl.DepartmentManagerImpl;
import com.isoft.iwechat.corporation.addressbook.tag.TagManager;
import com.isoft.iwechat.corporation.addressbook.tag.impl.TagManagerImpl;
import com.isoft.iwechat.corporation.addressbook.user.UserManager;
import com.isoft.iwechat.corporation.addressbook.user.impl.UserManagerImpl;
import com.isoft.iwechat.corporation.application.ApplicationManager;
import com.isoft.iwechat.corporation.application.impl.ApplicationMangerImpl;
import com.isoft.iwechat.corporation.media.MediaManager;
import com.isoft.iwechat.corporation.media.impl.MediaManagerImpl;
import com.isoft.iwechat.corporation.menu.MenuManager;
import com.isoft.iwechat.corporation.menu.impl.MenuManagerImpl;
import com.isoft.iwechat.corporation.message.transmission.CorpMessenger;
import com.isoft.iwechat.corporation.message.transmission.impl.CorpMessengerImpl;
import com.isoft.iwechat.corporation.oa.OAManager;
import com.isoft.iwechat.corporation.oa.impl.OAManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(CorpProperties.class)
public class CorpConfig {
    @Autowired
    CorpProperties corpProperties;

    @Bean
    public TokenManager tokenManager(WeChatRestClient weChatRestClient, CorpProperties corpProperties) {
        return new TokenManagerImpl(weChatRestClient, corpProperties);
    }

    @Bean
    public WeChatRestClient wechatRestClient() {
        return new WeChatRestClientImpl(getRestTemplate());
    }

    @Bean
    public DepartmentManager departmentManager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new DepartmentManagerImpl(weChatRestClient, tokenManager);
    }

    @Bean
    public UserManager userManager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new UserManagerImpl(weChatRestClient, tokenManager);
    }

    @Bean
    public TagManager tagManager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new TagManagerImpl(weChatRestClient, tokenManager);
    }

    @Bean
    public ApplicationManager applicationManager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new ApplicationMangerImpl(weChatRestClient, tokenManager);
    }

    @Bean
    public CorpMessenger messager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new CorpMessengerImpl(weChatRestClient, tokenManager);
    }

    @Bean
    public MenuManager menuManager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new MenuManagerImpl(weChatRestClient, tokenManager);
    }

    @Bean
    public MediaManager mediaManager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new MediaManagerImpl(weChatRestClient, tokenManager);
    }

    @Bean
    public OAManager oaManager(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        return new OAManagerImpl(weChatRestClient, tokenManager);
    }

    protected PropertyNamingStrategy propertyNamingStrategy() {
        return PropertyNamingStrategy.SNAKE_CASE;
    }

    protected RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper());
        messageConverters.add(jsonMessageConverter);
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter());
        messageConverters.add(new FormHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    protected ObjectMapper objectMapper() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        ObjectMapper objectMapper = builder.build();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return objectMapper;
    }
}
