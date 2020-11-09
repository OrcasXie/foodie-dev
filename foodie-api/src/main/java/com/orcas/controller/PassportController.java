package com.orcas.controller;

import com.orcas.pojo.Users;
import com.orcas.pojo.bo.UserBO;
import com.orcas.service.UserService;
import com.orcas.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import java.time.Year;
import java.util.Collection;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/9/30 19:25
 */
@Api(value = "注册登陆", tags = "注册登陆相关接口")
@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "判断用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameExists")
    public JSONResult whetherUsernameExists(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名不能为空");
        }

        return userService.whetherUsernameExists(username)
                ? JSONResult.errorMsg("用户名已存在") : JSONResult.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/register")
    public JSONResult register(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        if (StringUtils.isAnyBlank(username, password, confirmPassword)) {
            return JSONResult.errorMsg("用户名或密码不能为空");
        }
        if (userService.whetherUsernameExists(username)) {
            return JSONResult.errorMsg("用户名已存在");
        }
        if (password.length() < 6) {
            return JSONResult.errorMsg("密码至少6位");
        }
        if (!StringUtils.equals(password, confirmPassword)) {
            return JSONResult.errorMsg("两次密码输入不一致");
        }
        Users user = userService.createUser(userBO);
        return JSONResult.ok();
    }
}
