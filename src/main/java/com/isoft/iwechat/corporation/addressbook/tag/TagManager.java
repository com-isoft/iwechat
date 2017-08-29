package com.isoft.iwechat.corporation.addressbook.tag;

import java.util.List;

public interface TagManager {
    /**
     * 创建标签
     * @param tagInfo 标签信息
     * @return 标签信息
     */
    TagInfo create(TagInfo tagInfo);

    /**
     * 更新标签名字
     * @param tagInfo 标签信息
     * @return
     */
    TagInfo update(TagInfo tagInfo);

    /**
     * 删除标签
     * @param tagId 标签id
     */
    void delete(Integer tagId);

    /**
     * 获取标签列表
     * @return 标签列表
     */
    List<TagInfo> list();

    /**
     * 获取标签成员
     * @param tagId 标签id
     * @return
     */
    TagMemberInfo member(Integer tagId);

    /**
     * 增加标签成员
     * @param tagId 标签id
     * @param userList 企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
     * @param partyList 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
     */
    void addMember(Integer tagId, List<String> userList, List<Integer> partyList);

    /**
     * 删除标签成员
     * @param tagId 标签id
     * @param userList 企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
     * @param partyList 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
     */
    void deleteMember(Integer tagId, List<String> userList, List<Integer> partyList);
}
