package com.isoft.iwechat.corporation.addressbook.department.impl;

import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.addressbook.department.DepartmentInfo;
import com.isoft.iwechat.corporation.addressbook.department.DepartmentManager;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentManagerImpl implements DepartmentManager {
    private final static String BASE_URL = CorpConstant.BASE_URL + "/department";
    private final static String CREATE_URL = BASE_URL + "/create";
    private final static String UPDATE_URL = BASE_URL + "/update";
    private final static String DELETE_URL = BASE_URL + "/delete";
    private final static String LIST_URL = BASE_URL + "/list";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;

    public DepartmentManagerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 添加部门
     *
     * @param departmentInfo 部门信息
     * @return 部门信息
     */
    @Override
    public DepartmentInfo create(DepartmentInfo departmentInfo) {
        DepartmentResponse response = weChatRestClient.postForObject(CREATE_URL, departmentInfo, DepartmentResponse.class, getVariables());

        departmentInfo.setId(response.getId());
        return departmentInfo;
    }

    /**
     * 修改部门
     *
     * @param departmentInfo 部门信息
     * @return 部门信息
     */
    @Override
    public DepartmentInfo update(DepartmentInfo departmentInfo) {
        weChatRestClient.postForObject(UPDATE_URL, departmentInfo, DepartmentResponse.class, getVariables());
        return departmentInfo;
    }

    /**
     * 删除部门
     *
     * @param departmentId 部门id
     */
    @Override
    public void delete(Integer departmentId) {
        Assert.notNull(departmentId,"部门id不能为空!");

        Map<String, String> variables = this.getVariables();
        variables.put("id", String.valueOf(departmentId));

        weChatRestClient.getForObject(DELETE_URL, DepartmentResponse.class, variables);
    }

    /**
     * 获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构
     *
     * @param departmentId 部门
     * @return 部门列表
     */
    @Override
    public List<DepartmentInfo> list(Integer departmentId) {
        Map<String, String> variables = this.getVariables();

        if (departmentId != null) {
            variables.put("id", String.valueOf(departmentId));
        }

        DepartmentListResponse response = weChatRestClient.getForObject(LIST_URL, DepartmentListResponse.class, variables);

        return response.getDepartment();
    }

    private Map<String, String> getVariables() {
        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(CorpConstant.ADDRESS_BOOK_AGENT_ID));

        return variables;
    }
}
