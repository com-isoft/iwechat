package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息
 */
public class NewsMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private News news;

    public NewsMessage(){
        this.msgType = TransmissionMessageType.news;
        this.news = new News();
    }

    @JsonIgnore
    public List<NewsItem> getArticles() {
        return this.news.getArticles();
    }

    public void setArticles(List<NewsItem> articles) {
        this.news.setArticles(articles);
    }

    public void addNewsItem(NewsItem item){
        this.getArticles().add(item);
    }

    class News{
        public News(){
            this.articles = new ArrayList<>();
        }
        private List<NewsItem> articles;

        public List<NewsItem> getArticles() {
            return articles;
        }

        public void setArticles(List<NewsItem> articles) {
            this.articles = articles;
        }
    }
}
