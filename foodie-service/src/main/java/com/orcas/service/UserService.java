package com.orcas.service;

import com.orcas.pojo.Users;
import com.orcas.pojo.bo.UserBO;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/9/30 17:56
 */
public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
     boolean whetherUsernameExists(String username);

    /**
     * 创建用户
     * @param userBO
     * @return
     */
     Users createUser(UserBO userBO);

}
