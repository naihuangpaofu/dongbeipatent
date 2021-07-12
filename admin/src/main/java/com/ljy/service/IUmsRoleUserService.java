package com.ljy.service;

import com.ljy.pojo.UmsRoleUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色与用户关联表 服务类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-09
 */
public interface IUmsRoleUserService extends IService<UmsRoleUser> {
    boolean save(Long roleId, Long[] userIds);
    List<UmsRoleUser> getUsersByRoleId(Long roleId);
}
