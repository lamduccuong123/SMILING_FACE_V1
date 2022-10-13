package com.example.onthicuoiky;

public class Sach {
    private String id;
    private String tenSach;

    public Sach(String id, String tenSach) {
        this.id = id;
        this.tenSach = tenSach;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
}
