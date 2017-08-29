package com.isoft.iwechat.corporation.oa.impl;

import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.oa.CheckInInfo;

import java.util.List;

public class CheckInResponse extends AbstractResponse {
    private List<CheckInInfo> result;

    public List<CheckInInfo> getResult() {
        return result;
    }

    public void setResult(List<CheckInInfo> result) {
        this.result = result;
    }
}
