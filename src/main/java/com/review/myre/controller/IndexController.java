/**
 * @Project Name: myre
 * @File Name: IndexController
 * @author wangzhihao E-mail: w15603919702@gmail.com
 * @date 2020-06-20 7:16 PM
 * @version 1.0
 * @By IDE: IntelliJ IDEA
 */
package com.review.myre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;


@Controller
public class IndexController implements Serializable {


    @GetMapping(value = "/index")
    public String index() {

        return "/index";
    }

    @GetMapping(value = "/login")
    public String login() {

        return "/login";
    }

}
