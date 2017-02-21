package com.smart.domain;

import javax.persistence.*;

/**
 * @author: wuchao
 * @date： 2017/2/20
 */
public class CommentLog extends BaseDomain {

    //想去
    public static final int WANT_TO_GO = 1;

    //去过
    public static final int HAVE_BEAN_GO = 2;

    //不想去
    public static final int DONT_WANT_TO_GO = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int logId;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private ViewSpace viewSpace;

    private String ip;

    @Column(name = "comment_type")
    private int commentType;

    public static int getWantToGo() {
        return WANT_TO_GO;
    }

    public static int getHaveBeanGo() {
        return HAVE_BEAN_GO;
    }

    public static int getDontWantToGo() {
        return DONT_WANT_TO_GO;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public ViewSpace getViewSpace() {
        return viewSpace;
    }

    public void setViewSpace(ViewSpace viewSpace) {
        this.viewSpace = viewSpace;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }
}
