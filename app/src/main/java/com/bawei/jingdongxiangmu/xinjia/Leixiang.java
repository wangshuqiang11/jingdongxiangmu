package com.bawei.jingdongxiangmu.xinjia;

/**
 * Created by Liu xiong biao on 2017/11/28.
 */

public class Leixiang {
    private int pid;
    private String img;
    private String name;
    private double price;

    public Leixiang(int pid, String img, String name, double price) {
        this.pid = pid;
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
