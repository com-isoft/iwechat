package com.isoft.iwechat.corporation.addressbook.department;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentInfo {
    /**
     * 部门名称。长度限制为1~64个字节，字符不能包括\:?”<>｜
     */
    private String name;

    /**
     * 父部门id
     */
    @JsonProperty(value = "parentid")
    private Integer parentId;

    /**
     * 在父部门中的次序值。order值大的排序靠前。有效的值范围是[0, 2^32)
     */
    private int order;

    /**
     * 部门id，整型。指定时必须大于1，否则自动生成
     */
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
