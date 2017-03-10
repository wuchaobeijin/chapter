package org.jfinal.model;


import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class Files extends Model<Files> {

    private static final long serialVersionUID = 1L;
    public static final Files dao = new Files();
    public Page<Files> paginate(int pageNumber, int pageSize) {
        return paginate(pageNumber, pageSize, "select *", "from file order by id asc");
    }

}
