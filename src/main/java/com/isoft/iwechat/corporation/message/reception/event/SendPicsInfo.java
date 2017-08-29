package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SendPicsInfo {
    @JsonProperty("Count")
    private int count;
    @JsonProperty("PicList")
    private List<PicItem> picList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PicItem> getPicList() {
        return picList;
    }

    public void setPicList(List<PicItem> picList) {
        this.picList = picList;
    }

    class PicItem{
        private String picMd5Sum;

        public String getPicMd5Sum() {
            return picMd5Sum;
        }

        public void setPicMd5Sum(String picMd5Sum) {
            this.picMd5Sum = picMd5Sum;
        }
    }
}
