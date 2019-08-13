package cn.bt.btdemo.entity.admin;

import cn.bt.btdemo.entity.Pager;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Data
@ApiModel("系统用户表")
public class Admin{

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("电话号码")
    private String phone;
    @ApiModelProperty("电子邮件")
    private String email;
    @ApiModelProperty("头像")
    private String portrait;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("组织id")
    private Integer organizationId;
    @ApiModelProperty("城市id")
    private String cityId;
    @ApiModelProperty("省份id")
    private String provinceId;
    @ApiModelProperty("状态 1：启用 2：停用")
    private Integer status;
    @ApiModelProperty("身份  1：教育厅，2：教育局，3：学校")
    private Integer type;
    //分页排序等
    @Transient
    @NotNull(message = "pager不能为空")
    @Valid
    private Pager pager;
}
