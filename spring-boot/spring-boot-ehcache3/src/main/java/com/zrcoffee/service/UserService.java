package com.zrcoffee.service;

import com.zrcoffee.entity.User;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author Terry
 * @version 2019-10-27
 */
public interface UserService {

    /**
     * 根据实体中的属性值进行查询
     *
     * @param entity 实体
     * @return 实体列表
     */
    List<User> find(User entity);

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return 实体
     */
    User findById(Long id);


    /**
     * 根据用户名称查询
     *
     * @param username 用户名称
     * @return 用户实体
     */
    User findByUsername(String username);

    /**
     * 新增
     *
     * @param entity 实体
     * @return 结果
     */
    Integer insert(User entity);

    /**
     * 更新
     *
     * @param entity 实体
     * @return 结果
     */
    User update(User entity);

    /**
     * 删除
     *
     * @param id 主键
     * @return 结果
     */
    Integer delete(Long id);

}
