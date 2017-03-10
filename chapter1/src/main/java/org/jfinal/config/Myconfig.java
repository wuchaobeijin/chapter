package org.jfinal.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import org.jfinal.handle.QqHandle;
import org.jfinal.model.Files;
import org.jfinal.model.Message;
import org.jfinal.model.User;

import java.io.File;

/**
 * @author: wuchao
 * @date： 2017/3/7
 */
public class Myconfig extends JFinalConfig {


    public void configConstant(Constants constants) {
        PropKit.use("config.properties");
        constants.setError404View("/page/user/error.jsp");
        constants.setDevMode(PropKit.getBoolean("devMode", false));
        constants.setViewType(ViewType.JSP);
        constants.setUploadedFileSaveDirectory(File.separator + "upload" + File.separator);
    }

    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class, "/page/index");
        routes.add("/user", UserController.class, "/page/user");
        routes.add("/message", MessageController.class, "/page/message");
        routes.add("/file", FileController.class, "/page/upload");

    }

    public void configPlugin(Plugins plugins) {
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        plugins.add(c3p0Plugin);

        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(activeRecordPlugin);

        activeRecordPlugin.addMapping("user", "userId", User.class);
        activeRecordPlugin.addMapping("message", "messageId", Message.class);
        activeRecordPlugin.addMapping("file", Files.class);

    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {
        handlers.add(new QqHandle());
    }

    @Override
    public void afterJFinalStart() {
        System.out.println("服务启动");
    }

    @Override
    public void beforeJFinalStop() {
        System.out.println("服务关闭");
    }

}
