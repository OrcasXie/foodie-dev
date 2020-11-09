package com.orcas.my.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/9/29 18:01
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
