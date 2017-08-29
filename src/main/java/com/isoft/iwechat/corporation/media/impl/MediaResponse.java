package com.isoft.iwechat.corporation.media.impl;

import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.media.MediaType;

public class MediaResponse extends AbstractResponse {
    private MediaType type;
    private String mediaId;
    private long createdAt;

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
