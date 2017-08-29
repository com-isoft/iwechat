package com.isoft.iwechat.corporation.menu;

public interface MenuManager {
    /**
     * 创建菜单
     * @param button 菜单
     * @param agentId 企业应用的id
     * @return 菜单
     */
    MenuButton create(int agentId, MenuButton button);

    /**
     * 获取菜单
     * @param agentId 企业应用的id
     * @return 菜单
     */
    MenuButton get(int agentId);

    /**
     * 删除菜单
     * @param agentId 企业应用的id
     */
    void delete(int agentId);
}
