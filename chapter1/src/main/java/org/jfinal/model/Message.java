package org.jfinal.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class Message extends Model<Message> {
    private static final long serialVersionUID = 1L;
    public static final Message dao = new Message();
    public Page<Message> paginate(int pageNumber, int pageSize) {
        return paginate(pageNumber, pageSize, "select *", "from message order by messageId asc");
    }
}
