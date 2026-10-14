package com.example.th02_quanlychitieu;

import java.io.Serializable;

public class Expense implements Serializable {
    private String tenKhoanChi;
    private double soTien;
    private String danhMuc;
    private String ngayChiTieu;
    private String ghiChu;

    public Expense(String tenKhoanChi, double soTien, String danhMuc, String ngayChiTieu, String ghiChu) {
        this.tenKhoanChi = tenKhoanChi;
        this.soTien = soTien;
        this.danhMuc = danhMuc;
        this.ngayChiTieu = ngayChiTieu;
        this.ghiChu = ghiChu;
    }

    public String getTenKhoanChi() { return tenKhoanChi; }
    public void setTenKhoanChi(String tenKhoanChi) { this.tenKhoanChi = tenKhoanChi; }
    public double getSoTien() { return soTien; }
    public void setSoTien(double soTien) { this.soTien = soTien; }
    public String getDanhMuc() { return danhMuc; }
    public void setDanhMuc(String danhMuc) { this.danhMuc = danhMuc; }
    public String getNgayChiTieu() { return ngayChiTieu; }
    public void setNgayChiTieu(String ngayChiTieu) { this.ngayChiTieu = ngayChiTieu; }
    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}