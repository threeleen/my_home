/**
 * @Project Name: myre
 * @File Name: TokenUtils
 * @author wangzhihao E-mail: w15603919702@gmail.com
 * @date 2020-06-25 6:47 PM
 * @version 1.0
 * @By IDE: IntelliJ IDEA
 */
package com.review.myre.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.review.myre.entity.ReviewUser;

public class TokenUtils {


    public String getToken(ReviewUser user) {
        String token = "";
        token = JWT.create().withAudience(user.getUserId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }


}
