package com.itheima.ssm.domain;

import java.util.List;

public class Permission {

    private Integer id;
    private String permissionName;
    private String url;
    private List<Role> roles;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Permission() {
    }

    public Permission(Integer id, String permissionName, String url, List<Role> roles) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
        this.roles = roles;
    }
}
