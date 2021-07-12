package com.ljy.service;

import com.ljy.pojo.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-09
 */
public interface IUmsRoleService extends IService<UmsRole> {
    List<UmsRole> list(String name);
}
