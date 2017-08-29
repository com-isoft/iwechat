package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.addressbook.user.UserExtraAttribute;
import com.isoft.iwechat.corporation.message.reception.ContactChangeType;

/**
 * 新增成员事件
 */
public class UserCreateEvent extends AbstractEventMessage {
    public UserCreateEvent() {
        this.event = EventType.change_contact;
        this.changeType = ContactChangeType.create_user;
    }

    @JsonProperty("ChangeType")
    private ContactChangeType changeType;
    @JsonProperty("UserId")
    private String userId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Department")
    private String department;
    @JsonProperty("Position")
    private String position;
    @JsonProperty("Mobile")
    private String mobile;
    @JsonProperty("Gender")
    private int gender;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Status")
    private int status;
    @JsonProperty("Avatar")
    private String avatar;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("IsLeader")
    private int isLeader;
    @JsonProperty("Telephone")
    private String telephone;
    @JsonProperty("ExtAttr")
    private UserExtraAttribute extAttr;

    public ContactChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ContactChangeType changeType) {
        this.changeType = changeType;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public int getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(int isLeader) {
        this.isLeader = isLeader;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserExtraAttribute getExtAttr() {
        return extAttr;
    }

    public void setExtAttr(UserExtraAttribute extAttr) {
        this.extAttr = extAttr;
    }
}
