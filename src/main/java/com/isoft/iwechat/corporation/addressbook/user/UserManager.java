package com.isoft.iwechat.corporation.addressbook.user;

import java.util.List;

public interface UserManager {
    /**
     * 创建成员
     * @param userInfo 成员信息
     * @return 成员信息
     */
    UserInfo create(UserInfo userInfo);

    /**
     * 读取成员
     * @param userId 成员id
     * @return 成员信息
     */
    UserInfo get(String userId);

    /**
     * 更新成员
     * @param userInfo 成员信息
     * @return 成员信息
     */
    UserInfo update(UserInfo userInfo);

    /**
     * 删除成员
     * @param userId 成员id
     */
    void delete(String userId);

    /**
     * 批量删除成员
     * @param userIds 成员id集合
     */
    void batchDelete(List<String> userIds);

    /**
     * 获取部门成员简要信息
     * @param departmentId 部门id
     * @param fetchChild 是否递归获取子部门下面的成员
     * @return 成员集合
     */
    List<UserInfo> simpleist(Integer departmentId, boolean fetchChild);

    /**
     * 获取部门成员详细信息
     * @param departmentId 部门id
     * @param fetchChild 是否递归获取子部门下面的成员
     * @return 成员集合
     */
    List<UserInfo> list(Integer departmentId, boolean fetchChild);

    /**
     * userid转换成openid
     * 该接口使用场景为微信支付、微信红包和企业转账，企业号用户在使用微信支付的功能时，需要自行将企业号的userid转成openid。在使用微信红包功能时，需要将应用id和userid转成appid和openid才能使用。
     * @param userId 企业内的成员id
     * @param agentId 整型，需要发送红包的应用ID，若只是使用微信支付和企业转账，则无需该参数
     * @return
     */
    String convertToOpenId(String userId, Integer agentId);
}
