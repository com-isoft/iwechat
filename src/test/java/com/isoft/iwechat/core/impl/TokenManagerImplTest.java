package com.isoft.iwechat.core.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.corporation.configuration.CorpConfig;
import com.isoft.iwechat.corporation.configuration.CorpProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.isoft.iwechat.corporation.CorpConstant.ADDRESS_BOOK_AGENT_ID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class TokenManagerImplTest {
    @Autowired
    public CorpProperties corpPropertieis;

    @Autowired
    public TokenManager tokenManager;

    @Test
    public void getToken() throws Exception {
        String token = tokenManager.getToken(ADDRESS_BOOK_AGENT_ID);
        System.out.println(token);
    }

    @Test
    public void concurrentTest() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i=0;i<10;i++) {
            service.execute(() -> {
                String token = tokenManager.getToken(ADDRESS_BOOK_AGENT_ID);
                System.out.println(token);
            });
        }

        Thread.sleep(10000);

        service.shutdown();
    }

}