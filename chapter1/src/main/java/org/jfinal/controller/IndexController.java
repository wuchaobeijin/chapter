package org.jfinal.controller;

import com.jfinal.core.Controller;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class IndexController extends Controller {


    public void index() {
        render("index.jsp");
    }


}
