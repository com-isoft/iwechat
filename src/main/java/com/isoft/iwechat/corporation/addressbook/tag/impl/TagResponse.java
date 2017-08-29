package com.isoft.iwechat.corporation.addressbook.tag.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.core.AbstractResponse;

public class TagResponse extends AbstractResponse {
    @JsonProperty(value = "tagid")
    private Integer tagId;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
