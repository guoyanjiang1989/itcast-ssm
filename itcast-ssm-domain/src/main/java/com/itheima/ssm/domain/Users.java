package com.itheima.ssm.domain;

public class Users {

    private Integer id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private Integer status;//状态0 未开启 1 开启
    private String statusStr;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        //状态0 未开启 1 开启
        if (status == 0){
            statusStr = "未启用";
        }else if (status == 1){
            statusStr = "开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Users(Integer id, String email, String username, String password, String phoneNum, Integer status, String statusStr) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.status = status;
        this.statusStr = statusStr;
    }

    public Users() {
    }
}
