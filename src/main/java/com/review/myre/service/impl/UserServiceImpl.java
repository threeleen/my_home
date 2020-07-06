/**
 * @Project Name: myre
 * @File Name: UserServiceImpl
 * @author wangzhihao E-mail: w15603919702@gmail.com
 * @date 2020-06-03 10:00 PM
 * @version 1.0
 * @By IDE: IntelliJ IDEA
 */
package com.review.myre.service.impl;


import com.review.myre.dao.mapper.ReviewUserMapper;
import com.review.myre.entity.ReviewUser;
import com.review.myre.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    public ReviewUserMapper rUserMapper;

    @Override
    public ReviewUser queryUser(Integer id) {

        ReviewUser re = rUserMapper.selectByPrimaryKey(id);


        return re;
    }

    @Override
    public ReviewUser queryUserByUsername(String username) {

        ReviewUser reviewUser = rUserMapper.selectByUsername(username);


        return reviewUser;
    }


    public Integer addUserService(ReviewUser reviewUser) {

        int result = rUserMapper.insert(reviewUser);

        return result;

    }


}
