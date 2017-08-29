package com.isoft.iwechat.corporation.addressbook.tag;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 标签信息
 */
public class TagInfo {
    /**
     * 标签名称，长度限制为32个字（汉字或英文字母），标签名不可与其他标签重名。
     */
    @JsonProperty(value = "tagname")
    private String name;

    /**
     * 标签id，非负整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。
     */
    @JsonProperty(value = "tagid")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
