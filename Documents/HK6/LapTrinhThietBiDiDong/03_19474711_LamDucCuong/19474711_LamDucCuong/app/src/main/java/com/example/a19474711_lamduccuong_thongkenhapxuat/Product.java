package com.example.a19474711_lamduccuong_thongkenhapxuat;

import java.util.Date;

public class Product {
    private String id;
    private boolean nhapXuat;
    private String soLuong;
    private String tenHangHoa;
    private Date ngay;

    public Product(String id, boolean nhapXuat, String soLuong, String tenHangHoa, Date ngay) {
        this.id = id;
        this.nhapXuat = nhapXuat;
        this.soLuong = soLuong;
        this.tenHangHoa = tenHangHoa;
        this.ngay = ngay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isNhapXuat() {
        return nhapXuat;
    }

    public void setNhapXuat(boolean nhapXuat) {
        this.nhapXuat = nhapXuat;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
}
