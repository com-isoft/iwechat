package com.isoft.iwechat.corporation.message.reception;

/**
 * 批量任务类型
 */
public enum BatchJobType {
    /**
     * 增量更新成员
     */
    sync_user,

    /**
     * 全量覆盖成员
     */
    replace_user,

    /**
     * 邀请成员关注
     */
    invite_user,

    /**
     * 全量覆盖部门
     */
    replace_party
}
