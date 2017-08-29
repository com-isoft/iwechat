package com.isoft.iwechat.corporation.addressbook.department;

import java.util.List;

/**
 * department manager
 */
public interface DepartmentManager {
    /**
     * 添加部门
     * @param departmentInfo 部门信息
     * @return 部门信息
     */
    DepartmentInfo create(DepartmentInfo departmentInfo);

    /**
     * 修改部门
     * @param departmentInfo 部门信息
     * @return 部门信息
     */
    DepartmentInfo update(DepartmentInfo departmentInfo);

    /**
     * 删除部门
     * @param departmentId 部门id
     */
    void delete(Integer departmentId);

    /**
     * 获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构
     * @param departmentId 部门
     * @return 部门列表
     */
    List<DepartmentInfo> list(Integer departmentId);
}
