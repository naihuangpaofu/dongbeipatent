package com.ljy.service;

import com.ljy.pojo.PmsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-10
 */
public interface IPmsCategoryService extends IService<PmsCategory> {
    List<PmsCategory> getByParentId(Long parentId);
    List<PmsCategory> getAll(Long parentId);
}
