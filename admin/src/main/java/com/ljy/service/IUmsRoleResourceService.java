package com.ljy.service;

import com.ljy.pojo.UmsRoleResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色关联资源 服务类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-09
 */
public interface IUmsRoleResourceService extends IService<UmsRoleResource> {
    boolean save(Long roleId, Long[] resourceIds);
    List<Long> getByRoleId(Long roleId);
}
