package com.isoft.iwechat.corporation.menu;

import com.isoft.iwechat.corporation.configuration.CorpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class MenuManagerTest {
    @Autowired
    MenuManager menuManager;

    @Test
    public void create() throws Exception {
        menuManager.delete(1000002);
        MenuButton menuButton = new MenuButton();
        menuButton.addButton(new Button("测试", "https://www.baidu.com"));
        Button btn = new Button("扫码");
        btn.addButton(new Button("扫码一", "sacncode-1", ButtonType.scancode_push));
        btn.addButton(new Button("扫码二", "sacnwati_1", ButtonType.scancode_waitmsg));
        menuButton.addButton(btn);

        menuManager.create(1000002, menuButton);

        MenuButton menuButton1 = menuManager.get(1000002);
        System.out.println(menuButton1.getButton().size());
    }
}