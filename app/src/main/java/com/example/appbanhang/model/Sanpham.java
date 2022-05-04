package com.example.appbanhang.model;

public class Sanpham {
    public int ID;
    public String TensanPham;
    public Integer Giasanpham;
    public String Hinhanhsanpham;
    public String Motasanpham;
    public int IDSanpham;

    public Sanpham(int ID, String tensanPham, Integer giasanpham, String hinhanhsanpham, String motasanpham, int IDSanpham) {
        this.ID = ID;
        this.TensanPham = tensanPham;
        this.Giasanpham = giasanpham;
        this.Hinhanhsanpham = hinhanhsanpham;
        this.Motasanpham = motasanpham;
        this.IDSanpham = IDSanpham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensanPham() {
        return TensanPham;
    }

    public void setTensanPham(String tensanPham) {
        TensanPham = tensanPham;
    }

    public Integer getGiasanpham() {
        return Giasanpham;
    }

    public void setGiasanpham(Integer giasanpham) {
        Giasanpham = giasanpham;
    }

    public String getHinhanhsanpham() {
        return Hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        Hinhanhsanpham = hinhanhsanpham;
    }

    public String getMotasanpham() {
        return Motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        Motasanpham = motasanpham;
    }

    public int getIDSanpham() {
        return IDSanpham;
    }

    public void setIDSanpham(int IDSanpham) {
        this.IDSanpham = IDSanpham;
    }
}
