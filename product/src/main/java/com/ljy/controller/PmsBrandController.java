package com.ljy.controller;


import com.ljy.pojo.PmsBrand;
import com.ljy.service.AdminService;
import com.ljy.service.IPmsBrandService;
import com.ljy.util.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-08
 */
@RestController
@RequestMapping("/pms-brand")
public class PmsBrandController {
    @Resource
    IPmsBrandService brandService;
    @Resource
    AdminService adminService;
    @GetMapping("/list")
    ResultJson list(Integer pageNo,Integer pageSize, String name) {
        return ResultJson.success(brandService.page(pageNo,pageSize,name));
    }
    @PostMapping("/add")
    ResultJson add(PmsBrand pmsBrand, MultipartFile file) {
        pmsBrand.setLogo(adminService.upload(file));
        return ResultJson.success(brandService.save(pmsBrand),"添加品牌成功");
    }
    @GetMapping("/getone")
    ResultJson getone(Long id) {
        return ResultJson.success(brandService.getById(id));
    }
    @PostMapping("/update")
    ResultJson update(PmsBrand pmsBrand, MultipartFile file) {
        if(file != null && file.getSize() > 0) {
            pmsBrand.setLogo(adminService.upload(file));
        }
        return ResultJson.success(brandService.updateById(pmsBrand),"修改品牌成功");
    }
    @PostMapping("/del")
    ResultJson del(PmsBrand pmsBrand) {
        String message = pmsBrand.getActive() == 0 ? "删除品牌成功" : "恢复品牌成功";
        return ResultJson.success(brandService.updateById(pmsBrand),message);
    }
//    AdminService adminService;
//    @GetMapping("/index")
//    String index(){
////        RestTemplate restTemplate = new RestTemplate();
//        String str = adminService.index();
//        return str;
//    }

}
