package com.example.bai5;

public class Product {
    private String name;
    private String moTa;
    private String gia;
    private int picture;

    public Product(String name, String moTa, String gia, int picture) {
        this.name = name;
        this.moTa = moTa;
        this.gia = gia;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
