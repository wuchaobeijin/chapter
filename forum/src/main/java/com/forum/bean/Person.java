package com.forum.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户类
 *
 * @author: wuchao
 * @date： 2017/2/16
 */
@Entity
@Table
public class Person extends BaseBean {
    private String account;
    private String password;
    private String sex;
    private String name;
    private String birthday;
    private String email;
    private String ipCreated;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateLastActived;
    private String ipLastActived;
    @ManyToMany(mappedBy = "administrators")
    private Set<Board> boardsAdministrated = new HashSet<Board>();

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpCreated() {
        return ipCreated;
    }

    public void setIpCreated(String ipCreated) {
        this.ipCreated = ipCreated;
    }

    public Date getDateLastActived() {
        return dateLastActived;
    }

    public void setDateLastActived(Date dateLastActived) {
        this.dateLastActived = dateLastActived;
    }

    public String getIpLastActived() {
        return ipLastActived;
    }

    public void setIpLastActived(String ipLastActived) {
        this.ipLastActived = ipLastActived;
    }

    public Set<Board> getBoardsAdministrated() {
        return boardsAdministrated;
    }

    public void setBoardsAdministrated(Set<Board> boardsAdministrated) {
        this.boardsAdministrated = boardsAdministrated;
    }
}
