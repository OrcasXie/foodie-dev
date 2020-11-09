package com.orcas.service.impl;

import com.orcas.enums.Sex;
import com.orcas.mapper.UsersMapper;
import com.orcas.pojo.Users;
import com.orcas.pojo.bo.UserBO;
import com.orcas.service.UserService;
import com.orcas.utils.DateUtil;
import com.orcas.utils.JSONResult;
import com.orcas.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/9/30 18:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String DEFAULT_FACE = "https://cdn.jsdelivr.net/gh/OrcasXie/ImgRepo/others/avatar.jpg";

    private static final String DEFAULT_BIRTHDAY = "1900-01-01";

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean whetherUsernameExists(String username) {
        Example userExample = new Example(Users.class);
        userExample.createCriteria().andEqualTo("username", username);
        Users result = usersMapper.selectOneByExample(userExample);
        return result != null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(UserBO userBO) {
        Users user = null;
        String userId = sid.nextShort();
        try {
            user = Users.builder()
                    .id(userId)
                    .username(userBO.getUsername())
                    .password(MD5Utils.getMD5Str(userBO.getPassword()))
                    .nickname(userBO.getUsername())
                    .face(DEFAULT_FACE)
                    .birthday(DateUtil.stringToDate(DEFAULT_BIRTHDAY))
                    .sex(Sex.secret.type) // 默认性别保密
                    .createdTime(new Date())
                    .updatedTime(new Date())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        usersMapper.insert(user);
        return user;
    }
}
