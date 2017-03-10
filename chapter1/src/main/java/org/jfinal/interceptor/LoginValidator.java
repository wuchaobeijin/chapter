package org.jfinal.interceptor;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class LoginValidator extends Validator {

    @Override
    protected void validate(Controller controller) {
        validateRequiredString("username", "nameMsg", "请输入用户名");
        validateRequiredString("password", "passwordMsg", "请输入密码");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.keepPara("nameMsg");
        controller.keepPara("passwordMsg");
        controller.render("/page/index/index.jsp");
    }
}
