package com.isoft.iwechat.corporation.menu;

import java.util.ArrayList;
import java.util.List;

public class Button {
    public Button() {
        subButton = new ArrayList<>();
    }

    public Button(String name) {
        this();
        this.name = name;
    }

    public Button(String name, String key, ButtonType type) {
        this(name);
        this.key = key;
        this.type = type;
    }

    public Button(String name, String url) {
        this(name);
        this.url = url;
        this.type = ButtonType.view;
    }

    /**
     * 菜单的响应动作类型
     */
    protected ButtonType type;

    /**
     * 名称
     */
    protected String name;

    /**
     * click等点击类型必须
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * view类型必须
     * 网页链接，成员点击菜单可打开链接，不超过1024字节
     */
    private String url;

    private List<Button> subButton;

    public ButtonType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<Button> getSubButton() {
        return subButton;
    }

    public void addButton(Button button) {
        this.subButton.add(button);
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }
}
