package com.example.myfirstxm.service;

import com.example.myfirstxm.mbg.model.UmsAdmin;
import com.example.myfirstxm.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员Service
 * @author blind
 * @create 2023-03-02-16:10
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 获取用户所有权限(包括角色权限和+-权限)
     * @param admin
     * @return
     */
    List<UmsPermission> getPermissionList(Long admin);




}
