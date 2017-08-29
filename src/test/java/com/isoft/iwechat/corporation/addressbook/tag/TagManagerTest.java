package com.isoft.iwechat.corporation.addressbook.tag;

import com.isoft.iwechat.corporation.configuration.CorpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class TagManagerTest {
    @Autowired
    TagManager tagManager;

    @Test
    public void create() throws Exception {
        TagInfo tagInfo = new TagInfo();
        tagInfo.setName("测试");

        TagInfo other = tagManager.create(tagInfo);
        other.setName("测试123");

        tagManager.update(other);

        List<TagInfo> tags = tagManager.list();
        System.out.println(tags.size());

        tagManager.delete(other.getId());
    }

    @Test
    public void addMember() throws Exception {
        TagInfo tagInfo = new TagInfo();
        tagInfo.setName("测试");

        TagInfo other = tagManager.create(tagInfo);

        List<Integer> department=new ArrayList<>();

        department.add(4);
        department.add(5);

        List<String> users =new ArrayList<>();

        users.add("dlut_liuq");

        tagManager.addMember(other.getId(),users,department);

        TagMemberInfo memberInfo = tagManager.member(other.getId());

        tagManager.deleteMember(other.getId(),users,department);

        tagManager.delete(other.getId());
    }

}