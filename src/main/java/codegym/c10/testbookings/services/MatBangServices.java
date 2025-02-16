package codegym.c10.testbookings.services;

import codegym.c10.testbookings.eNum.LoaiMatBang;
import codegym.c10.testbookings.eNum.TrangThai;
import codegym.c10.testbookings.model.MatBang;
import codegym.c10.testbookings.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangServices implements IMatBangServices{
    private final List<MatBang> matBangList = new ArrayList<>();

    @Override
    public boolean addMatBang(MatBang matBang) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO mat_bang (ma_mat_bang, trang_thai, dien_tich, tang, loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc) values(?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, matBang.getMaMatBang());
            preparedStatement.setString(2, String.valueOf(matBang.getTrangThai()));
            preparedStatement.setInt(3, matBang.getDienTich());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setString(5, String.valueOf(matBang.getLoaiMatBang()));
            preparedStatement.setDouble(6,matBang.getPrice());
            preparedStatement.setDate(7, Date.valueOf(matBang.getNgayBatDau()));
            preparedStatement.setDate(8, Date.valueOf(matBang.getNgayKetThuc()));

            int result = preparedStatement.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MatBang> getAllMatBangs() {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM mat_bang";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(TrangThai.fromString(resultSet.getString("trang_thai")));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(LoaiMatBang.fromString(resultSet.getString("loai_mat_bang")));
                matBang.setPrice(resultSet.getDouble("gia_tien"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau").toLocalDate());
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc").toLocalDate());
                matBangList.add(matBang);


            }

            return matBangList;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteMaMatBang(String maMatBang) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM mat_bang WHERE ma_mat_bang = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, maMatBang);
            int result = preparedStatement.executeUpdate();
            return result > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateMatBang(MatBang matBang) {
        return false;
    }

    @Override
    public List<MatBang> finMatBangs(String maMatBang, Integer tang, Double price) {
        Connection connection = DatabaseConnection.getConnection();
        List<MatBang> matBangList = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM mat_bang WHERE 1=1");

        List<Object> params = new ArrayList<>();

        if (maMatBang != null && !maMatBang.trim().isEmpty()) {
            query.append(" AND ma_mat_bang = ?");
            params.add(maMatBang);
        }
        if (tang != null) {
            query.append(" AND tang = ?");
            params.add(tang);
        }
        if (price != null) {
            query.append(" AND gia_tien = ?");
            params.add(price);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i) instanceof String) {
                    preparedStatement.setString(i + 1, (String) params.get(i));
                } else if (params.get(i) instanceof Integer) {
                    preparedStatement.setInt(i + 1, (Integer) params.get(i));
                } else if (params.get(i) instanceof Double) {
                    preparedStatement.setDouble(i + 1, (Double) params.get(i));
                }
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MatBang matBang = new MatBang();
                    matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                    matBang.setTrangThai(TrangThai.fromString(resultSet.getString("trang_thai")));
                    matBang.setDienTich(resultSet.getInt("dien_tich"));
                    matBang.setTang(resultSet.getInt("tang"));
                    matBang.setLoaiMatBang(LoaiMatBang.fromString(resultSet.getString("loai_mat_bang")));
                    matBang.setPrice(resultSet.getDouble("gia_tien"));
                    matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau").toLocalDate());
                    matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc").toLocalDate());
                    matBangList.add(matBang);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi truy vấn CSDL", e);
        }

        return matBangList;
    }
}
