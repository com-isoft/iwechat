package com.isoft.iwechat.corporation.message.reception;

public enum ContactChangeType {
    /**
     * 新增成员事件
     */
    create_user,

    /**
     * 更新成员事件
     */
    update_user,

    /**
     * 删除成员事件
     */
    delete_user,

    /**
     * 新增部门事件
     */
    create_party,

    /**
     * 更新部门事件
     */
    update_party,

    /**
     * 删除部门事件
     */
    delete_party,

    /**
     * 标签变更事件
     */
    update_tag
}
