package com.test.manager.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ycw on 2016/3/8.
 */
//public class CommonInterceptor implements WebRequestInterceptor {
public class CommonInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    //implements WebRequestInterceptor
    public void preHandle(WebRequest webRequest) throws Exception {
        logger.info("-----1.进入preHandle-----");
        logger.info("-----1-----"+webRequest);
        webRequest.setAttribute("request","request",WebRequest.SCOPE_SESSION);
        webRequest.setAttribute("session","session",WebRequest.SCOPE_GLOBAL_SESSION);
        String contextPath = webRequest.getContextPath();
        HttpServletRequest request = (HttpServletRequest)webRequest;
        String requestUri = request.getRequestURI();
        String url = requestUri.substring(contextPath.length());
        logger.info("-----requestUri-----"+requestUri);
        logger.info("-----url-----"+url);
    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        logger.info("-----2.进入postHandle-----");
        logger.info("-----2-----"+webRequest);
        if(modelMap != null){
            for(String key: modelMap.keySet()){
                logger.info(key + "-----------------");
                modelMap.addAttribute("gamesListSelect","1");
                modelMap.addAttribute("gamesListOperate","2");
                modelMap.addAttribute("gamesListOperate2","3");
            }
        }
    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        logger.info("-----3.进入afterCompletion-----");
        logger.info(e + "-=-=-=-=-=-=-=-=-=-=");
    }

    //implements HandlerInterceptor
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("-----1.进入preHandle-----");
        String characterEncoding = httpServletRequest.getCharacterEncoding();
        logger.info("-----characterEncoding-----" + characterEncoding);
        String contextPath = httpServletRequest.getContextPath();
        String requestUri = httpServletRequest.getRequestURI();
        String url = requestUri.substring(contextPath.length());
        logger.info("-----url.contains(\"login\")-----"+url.contains("login"));
        logger.info("-----url-----"+url);
        if(url.contains("login")){
            logger.info("-----当前为登录页面-----");
            return true;
        }
        if(url == "/"){
            String uri = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath() + "/login";
            logger.info(uri);
            httpServletResponse.sendRedirect(uri);
            return false;
        }
        if(httpServletRequest.getSession().getAttribute("username") != null){
            logger.info("-----USERNAME in session-----" + httpServletRequest.getSession().getAttribute("username"));
            logger.info("-----requestUri-----"+requestUri);
            logger.info("-----url-----"+url);

        }else{
            String uri = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath() + "/login";
            logger.info(uri);
            httpServletResponse.sendRedirect(uri);
            return false;
        }
        if(url.contains("favicon.ico")){
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("-----2.进入postHandle-----");
        logger.info("-----2-----"+httpServletRequest.getRequestURI());
        logger.info("-----modelAndView-----"+modelAndView.getViewName());
        String[] urlArray = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length()).split("/");
        int i = 0;
        for(String str:urlArray){
            logger.info("-----urlArray["+(i++)+"]-----"+str);
        }
        if(modelAndView.getModelMap() != null && "first".equals(urlArray[1])){
            logger.info("-----modelAndView.getModelMap() != null");
            ModelMap modelMap = modelAndView.getModelMap();
            modelMap.addAttribute("username",httpServletRequest.getSession().getAttribute("username"));
            if("first".equals(urlArray[1]) && urlArray.length == 2){
                modelMap.addAttribute("gamesListSelect","This ");
                modelMap.addAttribute("gamesListOperate","is ");
                modelMap.addAttribute("gamesListOperate2","the first page! 【1】");
            }else if("yyy".equals(urlArray[2]) && urlArray.length == 3){
                modelMap.addAttribute("gamesListSelect","This ");
                modelMap.addAttribute("gamesListOperate","is ");
                modelMap.addAttribute("gamesListOperate2","the first page! 【2】");
            }else if("index".equals(urlArray[2]) && urlArray.length == 3){
                modelMap.addAttribute("gamesListSelect","This ");
                modelMap.addAttribute("gamesListOperate","is ");
                modelMap.addAttribute("gamesListOperate2","the second page! 【3】");
            }else if("relogin".equals(urlArray[2]) && urlArray.length == 3){
                modelMap.addAttribute("gamesListSelect","This ");
                modelMap.addAttribute("gamesListOperate","is ");
                modelMap.addAttribute("gamesListOperate2","the third page! 【4】");
            }else{

            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("-----3.进入afterCompletion-----");
    }
}
