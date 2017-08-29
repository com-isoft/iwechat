package com.isoft.iwechat.corporation.application;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AllowPartyInfo {
    @JsonProperty(value = "partyid")
    private List<Integer> partyIds;

    public List<Integer> getPartyIds() {
        return partyIds;
    }

    public void setPartyIds(List<Integer> partyIds) {
        this.partyIds = partyIds;
    }
}
