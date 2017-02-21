package com.forum.bean;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author: wuchao
 * @date： 2017/2/16
 */
@Entity
@Table
public class Board extends BaseBean {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private  Category category;

    private String name;

    private String description;

    private int threadCount;

}
