package com.isoft.iwechat.corporation.oa;

import java.util.Date;
import java.util.List;

public interface OAManager {
    /**
     * 获取打卡数据
     * @param type 打卡类型。0：上下班打卡；1：外出打卡；2：全部打卡
     * @param startTime 获取打卡记录的开始时间。UTC时间戳
     * @param endTime 获取打卡记录的结束时间。UTC时间戳
     * @param userIds 需要获取打卡记录的用户列表
     * @return 签卡数据
     */
    List<CheckInInfo> getCheckInData(CheckInType type, Date startTime, Date endTime, List<String> userIds);

    /**
     * 获取审批数据
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param next_spnum 第一个拉取的审批单号，不填从该时间段的第一个审批单拉取
     * @return
     */
    List<ApprovalInfo> getApprovalData(Date startTime, Date endTime, Integer next_spnum);
}
