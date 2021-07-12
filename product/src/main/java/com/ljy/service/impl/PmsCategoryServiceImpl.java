package com.ljy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljy.pojo.PmsCategory;
import com.ljy.mapper.PmsCategoryMapper;
import com.ljy.service.IPmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-10
 */
@Service
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory> implements IPmsCategoryService {

    public List<PmsCategory> getByParentId(Long parentId, Integer active) {
        QueryWrapper<PmsCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",parentId);
        if(active != null) {
            wrapper.eq("active",active);
        }
        List<PmsCategory> list = this.list(wrapper);
        for(PmsCategory category : list) {
            if(category.getActive() == 1) {
                category.setChildren(getByParentId(category.getId(),active));
            }
        }
        return list;
    }

    @Override
    public List<PmsCategory> getByParentId(Long parentId) {
        return this.getByParentId(parentId,null);
    }

    @Override
    public List<PmsCategory> getAll(Long parentId) {
        return this.getByParentId(parentId,1);
    }
}
