package com.test.manager.controller;

import com.test.manager.model.User;
import com.test.manager.service.IUserService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ycw on 2016/3/8.
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    private static  final org.slf4j.Logger logger = LoggerFactory.getLogger(FirstController.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value = {"","/yyy"}, params="id!=2" ,method = RequestMethod.GET)
    public String index0(int id,ModelMap modelMap){
        List<User> userList = userService.findAll();
        logger.info("-----userList.length-----" + userList.size() + "------id = " + id);
        modelMap.put("userList",userList);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index1(ModelMap modelMap){
        List<User> userList = userService.findAll();
        modelMap.put("userList",userList);
        return "index";
    }

    @RequestMapping(value = "/relogin", method = RequestMethod.GET)
    public String index2(ModelMap modelMap){
        modelMap.put("loginStatus","用户名或密码错误！请重新输入！");
        return "login";
    }

}
