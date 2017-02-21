package com.forum.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: wuchao
 * @date： 2017/2/16
 */
@MappedSuperclass
public class BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private boolean deleted;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;
}
