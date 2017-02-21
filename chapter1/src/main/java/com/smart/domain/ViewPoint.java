package com.smart.domain;

import javax.persistence.*;

/**
 * @author: wuchao
 * @date： 2017/2/20
 */
@Entity
@Table(name = "t_view_point")
public class ViewPoint extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private int pointId;

    @Column(name = "point_name")
    private String pointName;

    @Column(name = "ticket_price")
    private float ticketPrice;

    private String description;

    @Column(name = "img_file")
    private String imgFile;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private ViewSpace viewSpace = new ViewSpace();

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public ViewSpace getViewSpace() {
        return viewSpace;
    }

    public void setViewSpace(ViewSpace viewSpace) {
        this.viewSpace = viewSpace;
    }
}
