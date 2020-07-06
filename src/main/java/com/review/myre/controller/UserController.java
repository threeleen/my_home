/**
 * @Project Name: myre
 * @File Name: queryUser
 * @author wangzhihao E-mail: w15603919702@gmail.com
 * @date 2020-06-03 9:55 PM
 * @version 1.0
 * @By IDE: IntelliJ IDEA
 */
package com.review.myre.controller;


import com.alibaba.fastjson.JSONObject;
import com.review.myre.entity.ReviewUser;
import com.review.myre.service.impl.UserServiceImpl;
import com.review.myre.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;


@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Resource
    private UserServiceImpl usImpl;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ReviewUser findById(@RequestParam(value = "pid") Integer pid) {

        ReviewUser reviewUser1 = usImpl.queryUser(pid);

        return reviewUser1;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Integer addUser(@RequestBody ReviewUser reviewUser) {


        Integer integer = usImpl.addUserService(reviewUser);

        return integer;
    }
    @PostMapping(value = "/login.json")
    public Object login(@RequestBody ReviewUser user)  {
        JSONObject jsonObject = new JSONObject();
        ReviewUser reviewUser = usImpl.queryUserByUsername(user.getUsername());
        if (reviewUser != null){
            jsonObject.put("登录成功",200);
            TokenUtils tokenUtils = new TokenUtils();
            String token = tokenUtils.getToken(reviewUser);
            jsonObject.put("token",token);
            Cookie cook = new Cookie("token", token);
            cook.setPath("/");

            return jsonObject;
        }
        jsonObject.put("登录失败",501);

        return jsonObject;
    }
}
