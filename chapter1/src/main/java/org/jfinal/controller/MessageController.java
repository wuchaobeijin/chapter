package org.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import org.jfinal.model.Message;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class MessageController extends Controller {
    public void index() {
        setAttr("message", Message.dao.paginate(getParaToInt(0,1),10));
        render("getMessage.jsp");
    }

    public void submit() {
        String userId = getPara("userId");
        String title = getPara("title");
        String context = getPara("context");
        Record message = new Record().set("userId", userId).set("title", title).set("context", context);
        Db.save("message", message);
        redirect("/message");
    }

    public void edit() {
        int messageid = getParaToInt();
        setSessionAttr("messgaeId", messageid);
        render("add.jsp");
    }

    public void update() {
        String title = getPara("title");
        String context = getPara("context");
        Message.dao.findById(getParaToInt()).set("title",title).set("context",context).update();
        redirect("/message");
    }

    public void delete() {
        Db.deleteById("message", "messageId", getParaToInt());
        redirect("/message");
    }

    public void search() {
        String  ww = getPara("ww");
        Page<Record> messages = Db.paginate(1,5,"select * ", "from message where context = ?",ww);
        setAttr("messages",messages);
        render("getMessage.jsp");
    }




}
