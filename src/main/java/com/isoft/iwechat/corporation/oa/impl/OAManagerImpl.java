package com.isoft.iwechat.corporation.oa.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.oa.ApprovalInfo;
import com.isoft.iwechat.corporation.oa.CheckInInfo;
import com.isoft.iwechat.corporation.oa.CheckInType;
import com.isoft.iwechat.corporation.oa.OAManager;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OAManagerImpl implements OAManager {
    private final static String CHECKIN_URL = CorpConstant.BASE_URL + "/checkin/getcheckindata";
    private final static String APPROVAL_URL = CorpConstant.BASE_URL + "/corp/getapprovaldata";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;

    public OAManagerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 获取打卡数据
     *
     * @param type      打卡类型。0：上下班打卡；1：外出打卡；2：全部打卡
     * @param startTime 获取打卡记录的开始时间。UTC时间戳
     * @param endTime   获取打卡记录的结束时间。UTC时间戳
     * @param userIds   需要获取打卡记录的用户列表
     * @return 签卡数据
     */
    @Override
    public List<CheckInInfo> getCheckInData(CheckInType type, Date startTime, Date endTime, List<String> userIds) {
        Assert.notNull(type,"打卡类型不能为空！");
        Assert.notNull(startTime,"开始时间不能为空！");
        Assert.notNull(endTime,"截止时间不能为空！");
        Assert.notEmpty(userIds,"用户列表不能为空！");

        Map<String,Object> data = new HashMap<>();
        data.put("opencheckindatatype",type.ordinal()+1);
        data.put("starttime",startTime.getTime()/1000);
        data.put("endtime",endTime.getTime()/1000);
        data.put("useridlist",userIds);

        Map<String,String> variables = new HashMap<>();
        variables.put("access_token",this.tokenManager.getToken(3010011));

        CheckInResponse response = this.weChatRestClient.postForObject(CHECKIN_URL,data,CheckInResponse.class,variables);

        return response.getResult();
    }

    /**
     * todo
     * 获取审批数据
     *
     * @param startTime  开始时间
     * @param endTime    结束时间
     * @param next_spnum 第一个拉取的审批单号，不填从该时间段的第一个审批单拉取
     * @return
     */
    @Override
    public List<ApprovalInfo> getApprovalData(Date startTime, Date endTime, Integer next_spnum) {
        return null;
    }
}
