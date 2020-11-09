package com.orcas.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/10/3 16:07
 */
@Getter
@Setter
@ApiModel(value = "用户对象BO", description = "用户从客户端传入的数据的封装")
public class UserBO {
    @ApiModelProperty(value = "用户名", name = "username", example = "Orcas", required = true)
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;

    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "123456", required = true)
    private String confirmPassword;
}
