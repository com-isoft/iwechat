package com.isoft.iwechat.corporation.application;

import java.util.List;

public interface ApplicationManager {
    /**
     * 获取应用信息
     * @param agentId 应用id
     * @return 应用信息
     */
    ApplicationDetailInfo get(int agentId);

    /**
     * 设置应用信息
     * @param applicationInfo 应用信息
     */
    void set(ApplicationInfo applicationInfo);

    /**
     * 获取应用概况列表
     * @param agentId 应用id
     * @return 应用概况及和
     */
    List<ApplicationInfo> list(int agentId);
}
