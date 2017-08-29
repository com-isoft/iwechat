package com.isoft.iwechat.corporation.message.reception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.message.transmission.NewsItem;

import java.util.List;

/**
 * 图文消息
 */
public class ResponseNewsMessage extends AbstractResponseMessage {
    public ResponseNewsMessage() {
        this.msgType = ResponseMessageType.news;
    }

    @JsonProperty("ArticleCount")
    private int articleCount;

    @JsonProperty("Articles")
    private List<NewsItem> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public List<NewsItem> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsItem> articles) {
        this.articles = articles;
        this.articleCount = getArticles().size();
    }
}
