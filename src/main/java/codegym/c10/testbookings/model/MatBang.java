package codegym.c10.testbookings.model;

import codegym.c10.testbookings.eNum.LoaiMatBang;
import codegym.c10.testbookings.eNum.TrangThai;

import java.time.LocalDate;

public class MatBang {
    private int id;
    private String maMatBang;
    TrangThai trangThai;
    private int dienTich;
    private int tang;
    private LoaiMatBang loaiMatBang;
    private Double price;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public MatBang() {
    }

    public MatBang(int id, String maMatBang, TrangThai trangThai, int dienTich, int tang, LoaiMatBang loaiMatBang, Double price, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.id = id;
        this.maMatBang = maMatBang;
        this.trangThai = trangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.loaiMatBang = loaiMatBang;
        this.price = price;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(String maMatBang, TrangThai trangThai, int dienTich, int tang, LoaiMatBang loaiMatBang, Double price, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.trangThai = trangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.loaiMatBang = loaiMatBang;
        this.price = price;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public LoaiMatBang getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(LoaiMatBang loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "MatBang{" +
                "id=" + id +
                ", maMatBang='" + maMatBang + '\'' +
                ", trangThai=" + trangThai +
                ", dienTich=" + dienTich +
                ", tang=" + tang +
                ", loaiMatBang=" + loaiMatBang +
                ", price=" + price +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                '}';
    }
}
