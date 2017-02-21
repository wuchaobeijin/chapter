package com.forum.bean;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/16
 */
@Entity
@Table
public class Category extends BaseBean {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Board> boards = new ArrayList<Board>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
