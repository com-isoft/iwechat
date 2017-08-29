package com.isoft.iwechat.corporation.addressbook.tag.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.addressbook.tag.TagInfo;

import java.util.List;

public class TagListResponse extends AbstractResponse {
    @JsonProperty(value = "taglist")
    List<TagInfo> tags;

    public List<TagInfo> getTags() {
        return tags;
    }

    public void setTags(List<TagInfo> tags) {
        this.tags = tags;
    }
}
