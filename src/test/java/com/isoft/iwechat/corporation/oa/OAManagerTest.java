package com.isoft.iwechat.corporation.oa;

import com.isoft.iwechat.corporation.configuration.CorpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class OAManagerTest {
    @Autowired
    OAManager oaManager;
    @Test
    public void getCheckInData() throws Exception {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DATE,-5);

        List<String> ids= new ArrayList<>();
        ids.add("dlut_liuq");

        List<CheckInInfo> data= oaManager.getCheckInData(CheckInType.ALL,calendar.getTime(),new Date(),ids);

        System.out.println(data.size());
    }
}