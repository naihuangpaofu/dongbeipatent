package com.ljy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljy.pojo.UmsUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-05
 */
public interface IUmsUserService extends IService<UmsUser> {
    IPage<UmsUser> page(Integer pageNo, Integer pageSize, String name);
    List<UmsUser> getAll();
    Map<String,Object> login(String username, String password) throws Exception;
}
