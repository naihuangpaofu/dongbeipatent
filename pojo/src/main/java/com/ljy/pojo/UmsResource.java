package com.ljy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ljy.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UmsResource extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类别 0 前端 1 后端
     */
    private Integer type;

    /**
     * 前端url
     */
    private String frontUrl;

    /**
     * 后端url
     */
    private String backUrl;

    /**
     * 父资源id 顶级0
     */
    private Long parentId;

    /**
     * 0无下级 1有下级
     */
    private Integer haschildren;

    /**
     * 定义子集
     */
    @TableField(exist = false)
    private List<UmsResource> children;
}
