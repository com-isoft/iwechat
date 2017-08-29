package com.isoft.iwechat.corporation.message.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * mpnews类型的图文消息，跟普通的图文消息在客户端表现上是一致的。
 * mpnews可以通过管理后台的“管理工具” - “消息群发助手”来发送，也可以通过以下描述的API接口，通过企业自己的平台进行发送。
 */
public class MPNewsMessage extends AbstractTransmissionMessage {
    @JsonProperty
    private MPNews mpnews;

    public MPNewsMessage(){
        this.msgType = TransmissionMessageType.mpnews;
        this.mpnews = new MPNews();
    }

    @JsonIgnore
    public List<MPNewsItem> getArticles() {
        return this.mpnews.getArticles();
    }

    public void setArticles(List<MPNewsItem> articles) {
        this.mpnews.setArticles(articles);
    }

    public void addNewsItem(MPNewsItem item){
        this.getArticles().add(item);
    }

    class MPNews{
        public MPNews(){
            this.articles = new ArrayList<>();
        }
        private List<MPNewsItem> articles;

        public List<MPNewsItem> getArticles() {
            return articles;
        }

        public void setArticles(List<MPNewsItem> articles) {
            this.articles = articles;
        }
    }
}
