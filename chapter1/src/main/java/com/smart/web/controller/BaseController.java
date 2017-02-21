package com.smart.web.controller;

import com.smart.cons.CommonConstant;
import com.smart.domain.User;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wuchao
 * @date： 2017/2/21
 */
public class BaseController {

    private static final String ERROR_MSG_KEY = "errMsg";


    public User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
    }


    public void setSessionUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
    }

    public final String getAppBaseUrl(HttpServletRequest request, String url) {
        Assert.hasLength(url, "url不能为空");
        Assert.isTrue(url.startsWith("/"), "必须以/打头");
        return request.getContextPath() + url;
    }


}
