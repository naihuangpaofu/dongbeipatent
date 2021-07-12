package com.ljy.service;

import com.ljy.pojo.PmsSku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * sku属性表 服务类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-11
 */
public interface IPmsSkuService extends IService<PmsSku> {
    List<PmsSku> list(Long categoryId);
    List<PmsSku> getByCategory(Long[] categoryIds);
}
