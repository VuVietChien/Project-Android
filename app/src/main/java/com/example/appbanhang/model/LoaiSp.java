package com.example.appbanhang.model;

public class LoaiSp {
    int id;
    String Tenloaisp;
    String Hinhanhloaisp;

    public LoaiSp(int id, String tenloaisp, String hinhanhloaisp) {
        this.id = id;
        this.Tenloaisp = tenloaisp;
        this.Hinhanhloaisp = hinhanhloaisp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloaisp() {
        return Tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        Tenloaisp = tenloaisp;
    }

    public String getHinhanhloaisp() {
        return Hinhanhloaisp;
    }

    public void setHinhanhloaisp(String hinhanhloaisp) {
        Hinhanhloaisp = hinhanhloaisp;
    }
}
