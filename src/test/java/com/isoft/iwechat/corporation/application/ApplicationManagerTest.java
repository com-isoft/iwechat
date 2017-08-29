package com.isoft.iwechat.corporation.application;

import com.isoft.iwechat.corporation.configuration.CorpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class ApplicationManagerTest {
    @Autowired
    ApplicationManager applicationManager;

    @Test
    public void get() throws Exception {
        ApplicationDetailInfo detailInfo = applicationManager.get(1000002);
        System.out.println(detailInfo.getDescription());
    }

    @Test
    public void set() throws Exception {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.setAgentId(1000002);
        applicationInfo.setName("测试1111");
        applicationInfo.setDescription("from test");
        applicationManager.set(applicationInfo);

        ApplicationDetailInfo detailInfo = applicationManager.get(1000002);
        System.out.println(detailInfo.getDescription());
    }

    @Test
    public void list() throws Exception {
        List<ApplicationInfo> apps = applicationManager.list(1000002);
        System.out.println(apps.size());
    }

}