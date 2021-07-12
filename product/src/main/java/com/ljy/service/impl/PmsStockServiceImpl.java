package com.ljy.service.impl;

import com.ljy.pojo.PmsStock;
import com.ljy.mapper.PmsStockMapper;
import com.ljy.service.IPmsStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku库存表 服务实现类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-11
 */
@Service
public class PmsStockServiceImpl extends ServiceImpl<PmsStockMapper, PmsStock> implements IPmsStockService {

}
