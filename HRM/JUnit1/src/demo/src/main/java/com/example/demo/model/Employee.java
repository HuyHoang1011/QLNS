/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;



import java.util.Date;

@Entity
@Table(name = "nhanvien") // Đảm bảo bảng 'nhanvien' khớp với cơ sở dữ liệu
public class Employee {

    @Id
    @Column(name = "manhanvien") // Ánh xạ đúng tên cột trong cơ sở dữ liệu
    private String maNhanVien;

    @Column(name = "cmnd") // Cột 'cmnd' trong cơ sở dữ liệu
    private String cmnd;

    @Column(name = "luongthuviec")
    private Double luongThuViec;

    @Column(name = "machucvu")
    private String maChucVu;

    @Column(name = "mahopdong")
    private String maHopDong;

    @Column(name = "maphong")
    private String maPhong;

    @Column(name = "matrinhdo")
    private String maTrinhDo;

    @Column(name = "ngaybatdauthuviec")
    @Temporal(TemporalType.DATE) // Đảm bảo định dạng ngày tháng đúng
    private Date ngayBatDauThuViec;

    @Column(name = "ngayketthucthuviec")
    @Temporal(TemporalType.DATE) // Đảm bảo định dạng ngày tháng đúng
    private Date ngayKetThucThuViec;

    @Column(name = "trangthai")
    private String trangThai;

    // Constructor không tham số
    public Employee() {
    }

    // Constructor với tất cả các trường
    public Employee(String maNhanVien, String cmnd, Double luongThuViec, String maChucVu, String maHopDong, 
                    String maPhong, String maTrinhDo, Date ngayBatDauThuViec, Date ngayKetThucThuViec, String trangThai) {
        this.maNhanVien = maNhanVien;
        this.cmnd = cmnd;
        this.luongThuViec = luongThuViec;
        this.maChucVu = maChucVu;
        this.maHopDong = maHopDong;
        this.maPhong = maPhong;
        this.maTrinhDo = maTrinhDo;
        this.ngayBatDauThuViec = ngayBatDauThuViec;
        this.ngayKetThucThuViec = ngayKetThucThuViec;
        this.trangThai = trangThai;
    }

    // Getters và Setters
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Double getLuongThuViec() {
        return luongThuViec;
    }

    public void setLuongThuViec(Double luongThuViec) {
        this.luongThuViec = luongThuViec;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(String maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public Date getNgayBatDauThuViec() {
        return ngayBatDauThuViec;
    }

    public void setNgayBatDauThuViec(Date ngayBatDauThuViec) {
        this.ngayBatDauThuViec = ngayBatDauThuViec;
    }

    public Date getNgayKetThucThuViec() {
        return ngayKetThucThuViec;
    }

    public void setNgayKetThucThuViec(Date ngayKetThucThuViec) {
        this.ngayKetThucThuViec = ngayKetThucThuViec;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // toString method (optional, để in đối tượng Employee)
    @Override
    public String toString() {
        return "Employee{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", luongThuViec=" + luongThuViec +
                ", maChucVu='" + maChucVu + '\'' +
                ", maHopDong='" + maHopDong + '\'' +
                ", maPhong='" + maPhong + '\'' +
                ", maTrinhDo='" + maTrinhDo + '\'' +
                ", ngayBatDauThuViec=" + ngayBatDauThuViec +
                ", ngayKetThucThuViec=" + ngayKetThucThuViec +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
