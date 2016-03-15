package com.test.manager.controller;

import com.test.manager.service.IUserService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by ycw on 2016/3/11.
 */
@Controller
@RequestMapping
public class ToLoginController {
    private static  final org.slf4j.Logger logger = LoggerFactory.getLogger(ToLoginController.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value ="tologin" ,method = RequestMethod.POST)
    public String toLogin(HttpServletRequest request, ModelMap modelMap) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String account = request.getParameter("password");
        if(username.equals(userService.getUserNameByAccount(account))){
            request.getSession().setAttribute("username",username);
            modelMap.put("loginStatus","登录成功！");
            return "redirect:/first/index";
        }
        return "redirect:/first/relogin";
    }
}
