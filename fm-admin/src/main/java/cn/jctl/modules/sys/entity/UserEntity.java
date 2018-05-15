package cn.jctl.modules.sys.entity;

import java.util.Date;
import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class UserEntity {
    private Long userId;
    private String names;
    private String age;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private String address;
    private Integer status;
    private List<Long> roleIdList;
    private List<String> roleList;
    private Date createTime;

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNames() {
        return names;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", names='" + names + '\'' +
                ", age='" + age + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", roleIdList=" + roleIdList +
                ", roleList=" + roleList +
                ", createTime=" + createTime +
                '}';
    }
}
