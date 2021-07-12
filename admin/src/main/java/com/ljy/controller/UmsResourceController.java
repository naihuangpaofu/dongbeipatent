package com.ljy.controller;


import com.ljy.service.IUmsResourceService;
import com.ljy.util.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-09
 */
@RestController
@RequestMapping("/ums-resource")
public class UmsResourceController {
    @Resource
    IUmsResourceService resourceService;
    @GetMapping("/list")
    ResultJson list() {
        return ResultJson.success(resourceService.getResource(0L));
    }
}
