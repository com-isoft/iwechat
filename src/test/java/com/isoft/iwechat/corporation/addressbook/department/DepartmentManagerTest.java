package com.isoft.iwechat.corporation.addressbook.department;

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
public class DepartmentManagerTest {
    @Autowired
    DepartmentManager departmentManager;

    @Test
    public void create() throws Exception {
        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.setName(String.valueOf(System.currentTimeMillis()));
        departmentInfo.setOrder(5);
        departmentInfo.setParentId(1);

        departmentInfo = departmentManager.create(departmentInfo);

        System.out.println(departmentInfo.getId());
    }

    @Test
    public void update() throws Exception {
        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.setId(6);
        departmentInfo.setName("测试77");
        departmentInfo.setOrder(5);
        departmentInfo.setParentId(1);

        departmentManager.update(departmentInfo);
    }

    @Test
    public void delete() throws Exception {
        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.setName(String.valueOf(System.currentTimeMillis()));
        departmentInfo.setOrder(5);
        departmentInfo.setParentId(1);

        departmentInfo = departmentManager.create(departmentInfo);

        departmentManager.delete(departmentInfo.getId());
    }

    @Test
    public void list() throws Exception {
        List<DepartmentInfo> list = departmentManager.list(1);
        System.out.println(list.size());
    }

}