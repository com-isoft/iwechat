package com.isoft.iwechat.corporation.addressbook.user;

import com.isoft.iwechat.corporation.configuration.CorpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class UserManagerTest {
    @Autowired
    UserManager userManager;

    @Test
    public void create() throws Exception {
        UserInfo info = new UserInfo();
        List<Integer> department=new ArrayList<>();

        department.add(4);
        department.add(5);

        info.setUserId(UUID.randomUUID().toString());
        info.setName("测试");
        info.setMobile("15542352666");
        info.setDepartment(department);

        info = userManager.create(info);

        UserInfo other = userManager.get(info.getUserId());

        System.out.println(other.getName());

        userManager.delete(other.getUserId());
    }

    @Test
    public void update(){
        UserInfo info = new UserInfo();
        List<Integer> department=new ArrayList<>();

        department.add(4);
        department.add(5);

        info.setUserId("490b45e5-d524-4458-911c-5c86c6380f24");
        info.setName("杨煜宇");
        info.setMobile("15542352666");
        info.setDepartment(department);

        userManager.update(info);
    }

    @Test
    public void list() throws Exception {
        List<UserInfo> list = userManager.list(1,false);
        System.out.println(list.size());
        list = userManager.simpleist(1,true);
        System.out.println(list.size());
    }

    @Test
    public void convertToOpenId() throws Exception {
        System.out.println(userManager.convertToOpenId("dlut_liuq",0));
    }

}