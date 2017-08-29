package com.isoft.iwechat.corporation.message.transmission;

public class MPNewsItem {
    /**
     * 标题，不超过128个字节，超过会自动截断
     */
    private String title;

    /**
     * 图文消息缩略图的media_id, 可以在上传多媒体文件接口中获得。此处thumb_media_id即上传接口返回的media_id
     */
    private String thumbMediaId;

    /**
     * 图文消息的作者，不超过64个字节
     */
    private String author;

    /**
     * 图文消息点击“阅读原文”之后的页面链接
     */
    private String contentSourceUrl;

    /**
     * 图文消息的内容，支持html标签，不超过666 K个字节
     */
    private String coutent;

    /**
     * 图文消息的描述，不超过512个字节，超过会自动截断
     */
    private String digest;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getCoutent() {
        return coutent;
    }

    public void setCoutent(String coutent) {
        this.coutent = coutent;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
