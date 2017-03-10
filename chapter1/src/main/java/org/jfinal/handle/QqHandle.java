package org.jfinal.handle;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class QqHandle extends Handler {

    @Override
    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, boolean[] booleen) {
        httpServletRequest.setAttribute("path", httpServletRequest.getContextPath());
        if (s.endsWith(".html")) {
            s = s.substring(0, s.length() - 5);
        }
        nextHandler.handle(s, httpServletRequest, httpServletResponse, booleen);
    }
}
