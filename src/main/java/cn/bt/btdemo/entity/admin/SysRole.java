package cn.bt.btdemo.entity.admin;

import cn.bt.btdemo.entity.Pager;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Data
@ApiModel("学校角色")
public class SysRole{

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("角色名称")
    private String title;
    @ApiModelProperty("创建时间")
    private String createTime;
    //分页排序等
    @Transient
    @NotNull(message = "pager不能为空")
    @Valid
    private Pager pager;
}
