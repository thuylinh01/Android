package com.example.th3b1;

public class NguoiDung {

    private String hoten;
    private String email;
    private String sdt;

    public NguoiDung() {
    }

    public NguoiDung(String hoten, String email, String sdt) {
        this.hoten = hoten;
        this.email = email;
        this.sdt = sdt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
