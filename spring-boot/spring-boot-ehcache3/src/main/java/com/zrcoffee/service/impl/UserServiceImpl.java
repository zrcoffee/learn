package com.zrcoffee.service.impl;

import com.zrcoffee.entity.User;
import com.zrcoffee.mapper.UserMapper;
import com.zrcoffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现
 *
 * @author Terry
 * @version 2019-10-27
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> find(User entity) {
        return userMapper.find(entity);
    }

    @Override
    @Cacheable(value = "defaultCache", key = "'user$' + #id.toString()")
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Integer insert(User entity) {
        return userMapper.insert(entity);
    }

    @Override
    @CachePut(value = "defaultCache", key = "'user$' + #entity.id")
    public User update(User entity) {
        userMapper.update(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "defaultCache", key = "'user$' + #id.toString()")
    public Integer delete(Long id) {
        User user = new User();
        user.setId(id);
        user.setStatus("99");
        return userMapper.update(user);
    }

}
