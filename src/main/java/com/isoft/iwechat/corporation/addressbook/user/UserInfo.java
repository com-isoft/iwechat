package com.isoft.iwechat.corporation.addressbook.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserInfo {
    public UserInfo() {
    }

    public UserInfo(String userId, String name, String mobile, List<Integer> department) {
        this.userId = userId;
        this.name = name;
        this.mobile = mobile;
        this.department = department;
    }

    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     */
    @JsonProperty(value = "userid")
    private String userId;

    /**
     * 成员名称。长度为1~64个字节
     */
    private String name;

    /**
     * 英文名。长度为1-64个字节。
     */
    private String englishName;

    /**
     * 手机号码。企业内必须唯一
     */
    private String mobile;

    /**
     * 成员所属部门id列表,不超过20个
     */
    private List<Integer> department;

    /**
     * 部门内的排序值，默认为0。数量必须和department一致，数值越大排序越前面。有效的值范围是[0, 2^32)
     */
    private List<Integer> order;

    /**
     * 职位信息。长度为0~64个字节
     */
    private String position;

    /**
     * 性别。1表示男性，2表示女性
     */
    private Integer gender;

    /**
     * 邮箱。长度为0~64个字节。企业内必须唯一
     */
    private String email;

    /**
     * 座机。长度0-64个字节。
     */
    private String telephone;

    /**
     * 上级字段，标识是否为上级。0是，1否
     */
    @JsonProperty(value = "isleader")
    private Boolean leader;

    /**
     * 成员头像的mediaid，通过多媒体接口上传图片获得的mediaid
     */
    private String avatarMediaid;

    /**
     * 启用/禁用成员。1表示启用成员，0表示禁用成员
     */
    private Boolean enable;

    /**
     * 自定义字段。自定义字段需要先在WEB管理端“我的企业” — “通讯录管理”添加，否则忽略未知属性的赋值
     * json格式
     */
    private UserExtraAttribute extattr;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Integer> getDepartment() {
        return department;
    }

    public void setDepartment(List<Integer> department) {
        this.department = department;
    }

    public List<Integer> getOrder() {
        return order;
    }

    public void setOrder(List<Integer> order) {
        this.order = order;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAvatarMediaid() {
        return avatarMediaid;
    }

    public void setAvatarMediaid(String avatarMediaid) {
        this.avatarMediaid = avatarMediaid;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    public UserExtraAttribute getExtattr() {
        return extattr;
    }

    public void setExtattr(UserExtraAttribute extattr) {
        this.extattr = extattr;
    }
}
