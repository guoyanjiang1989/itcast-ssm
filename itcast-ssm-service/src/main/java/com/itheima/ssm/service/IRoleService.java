package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    List<Permission> findOtherPermissions(Integer id) throws Exception;

    Role findById(Integer id) throws Exception;

    void addPermissionToRole(Integer roleID, Integer[] permissionIds) throws Exception;
}
