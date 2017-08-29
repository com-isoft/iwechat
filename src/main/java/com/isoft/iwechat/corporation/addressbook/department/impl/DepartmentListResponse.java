package com.isoft.iwechat.corporation.addressbook.department.impl;

import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.addressbook.department.DepartmentInfo;

import java.util.List;

public class DepartmentListResponse extends AbstractResponse {
    public List<DepartmentInfo> department;

    public List<DepartmentInfo> getDepartment() {
        return department;
    }

    public void setDepartment(List<DepartmentInfo> department) {
        this.department = department;
    }
}
