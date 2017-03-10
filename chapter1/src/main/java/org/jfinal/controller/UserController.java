package org.jfinal.controller;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.jfinal.interceptor.LalaInterceptor;
import org.jfinal.model.User;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class UserController extends Controller {

    public void Login() {
        String username = getPara("username");
        String password = getPara("password");
        User user = User.dao.checkLogin(username, password);
        if (user != null) {
            setSessionAttr("userId", user.get("userId"));
            setSessionAttr("userName", user.get("username"));
            redirect("/message");
        } else {
            render("error.jsp");
        }
    }

    @Clear(LalaInterceptor.class)
    public void lala() {

    }

}
