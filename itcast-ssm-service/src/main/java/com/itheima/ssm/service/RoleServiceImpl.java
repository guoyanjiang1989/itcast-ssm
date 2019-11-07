package com.itheima.ssm.service;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findOtherPermissions(Integer id) throws Exception {
        return roleDao.findRoleByIdAndAllPermission(id);
    }

    @Override
    public Role findById(Integer id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void addPermissionToRole(Integer roleID, Integer[] permissionIds) throws Exception {
        for (Integer permissionID:permissionIds){
            roleDao.addPermissionToRole(roleID,permissionID);
        }
    }
}
