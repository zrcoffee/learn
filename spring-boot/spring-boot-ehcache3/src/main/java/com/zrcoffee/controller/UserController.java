package com.zrcoffee.controller;

import com.zrcoffee.entity.User;
import com.zrcoffee.service.UserService;
import com.zrcoffee.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 *
 * @author Terry
 * @version 2019-10-27
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user = (User) CacheUtil.get("defaultCache", "user");
        if (user == null) {
            user = userService.findById(id);
            CacheUtil.put("defaultCache", "user", user);
        }
        return user;
    }

    @RequestMapping(value = "/find/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User find(@PathVariable Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map insert() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setRealname("测试新增");
        user.setSex("0");
        user.setEmail("test@zrcoffee.com");
        user.setStatus("00");
        user.setCreateBy("system");
        map.put("result", userService.insert(user));
        return map;
    }

    @RequestMapping(value = "/update/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User update(@PathVariable Long id) {
        User user = userService.findById(id);
        user.setRemark("测试更新");
        return userService.update(user);
    }

    @RequestMapping(value = "/delete/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map delete(@PathVariable Long id) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("result", userService.delete(id));
        return map;
    }

}
