package com.example.quanlysinhvien;

public class SinhVien {
    private String hoTen;
    private String lop;
    private int tinhTrang;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String lop, int tinhTrang) {
        this.hoTen = hoTen;
        this.lop = lop;
        this.tinhTrang = tinhTrang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
