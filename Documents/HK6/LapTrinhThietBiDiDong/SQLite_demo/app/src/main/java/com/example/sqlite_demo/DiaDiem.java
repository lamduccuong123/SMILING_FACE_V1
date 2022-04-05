package com.example.sqlite_demo;

public class DiaDiem {
    private int id;
    private String tenDiaDiem;

    public DiaDiem() {

    }

    public DiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public DiaDiem(int id, String tenDiaDiem) {
        this.id = id;
        this.tenDiaDiem = tenDiaDiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }
}
