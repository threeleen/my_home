/**
 * @Project Name: myre
 * @File Name: UserService
 * @author wangzhihao E-mail: w15603919702@gmail.com
 * @date 2020-06-03 9:59 PM
 * @version 1.0
 * @By IDE: IntelliJ IDEA
 */
package com.review.myre.service;

import com.review.myre.entity.ReviewUser;

public interface UserService {


    ReviewUser queryUser(Integer id);


    ReviewUser queryUserByUsername(String username);
}
