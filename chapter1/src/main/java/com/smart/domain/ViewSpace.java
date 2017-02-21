package com.smart.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/20
 */
@Entity
@Table(name = "t_view_space")
public class ViewSpace extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "space_id")
    private int spaceId;

    @Column(name = "space_name")
    private String spaceName;

    private String description;

    private String website;
    private String address;

    @Column(name = "want_num")
    private int wantNum;

    @Column(name = "been_num")
    private int beenNum;

    @Column(name = "notwant_num")
    private int notwantNum;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "viewSpace", cascade = CascadeType.ALL)
    private List<ViewPoint> viewPoints;


    public String getBriefDesc() {
        if (description == null) {
            return "";
        } else {
            int len = description.length() > 100 ? 100 : description.length();
            return description.substring(0,len);
        }
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWantNum() {
        return wantNum;
    }

    public void setWantNum(int wantNum) {
        this.wantNum = wantNum;
    }

    public int getBeenNum() {
        return beenNum;
    }

    public void setBeenNum(int beenNum) {
        this.beenNum = beenNum;
    }

    public int getNotwantNum() {
        return notwantNum;
    }

    public void setNotwantNum(int notwantNum) {
        this.notwantNum = notwantNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ViewPoint> getViewPoints() {
        return viewPoints;
    }

    public void setViewPoints(List<ViewPoint> viewPoints) {
        this.viewPoints = viewPoints;
    }
}
