<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Mặt Bằng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0 auto;
            max-width: 600px;
        }
        h1 {
            text-align: center;
        }
        form {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button.save {
            background-color: #4CAF50;
            color: white;
        }
        button.cancel {
            background-color: #f44336;
            color: white;
            margin-left: 10px;
        }
    </style>
</head>
<body>

<h1>Chỉnh Sửa Mặt Bằng</h1>

<%
    String maMatBang = request.getParameter("maMatBang");
    String trangThai = request.getParameter("trangThai");
    String dienTich = request.getParameter("dienTich");
    String tang = request.getParameter("tang");
    String loaiMatBang = request.getParameter("loaiMatBang");
    String price = request.getParameter("price");
    String ngayBatDau = request.getParameter("ngayBatDau");
    String ngayKetThuc = request.getParameter("ngayKetThuc");
%>

<form id="formMatBang" action="matbang?action=edit" method="post" accept-charset="UTF-8">
    <label for="maMatBang">Mã Mặt Bằng:</label>
    <input type="text" id="maMatBang" name="maMatBang" value="<%= maMatBang != null ? maMatBang : "" %>"
           pattern="[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}"
           title="Mã Mặt Bằng phải có định dạng XXX-XX-XX, gồm chữ cái và số"
           required />

    <label for="trangThai">Trạng Thái:</label>
    <select id="trangThai" name="trangThai" required>
        <option value="">-- Chọn Trạng Thái --</option>
        <option value="Trống" <%= "Trống".equals(trangThai) ? "selected" : "" %>>Trống</option>
        <option value="Hạ Tầng" <%= "Hạ Tầng".equals(trangThai) ? "selected" : "" %>>Hạ Tầng</option>
        <option value="Đầy Đủ" <%= "Đầy Đủ".equals(trangThai) ? "selected" : "" %>>Đầy Đủ</option>
    </select>

    <label for="dienTich">Diện Tích (m²):</label>
    <input type="number" id="dienTich" name="dienTich" min="21" value="<%= dienTich != null ? dienTich : "" %>" required />

    <label for="tang">Tầng:</label>
    <select id="tang" name="tang" required>
        <option value="">-- Chọn Tầng --</option>
        <% for (int i = 1; i <= 15; i++) { %>
        <option value="<%= i %>" <%= String.valueOf(i).equals(tang) ? "selected" : "" %>>Tầng <%= i %></option>
        <% } %>
    </select>

    <label for="loaiMatBang">Loại Mặt Bằng:</label>
    <select id="loaiMatBang" name="loaiMatBang" required>
        <option value="">-- Chọn Loại --</option>
        <option value="Văn Phòng Chia Sẻ" <%= "Văn Phòng Chia Sẻ".equals(loaiMatBang) ? "selected" : "" %>>Văn Phòng Chia Sẻ</option>
        <option value="Văn Phòng Chọn Gói" <%= "Văn Phòng Chọn Gói".equals(loaiMatBang) ? "selected" : "" %>>Văn Phòng Chọn Gói</option>
    </select>

    <label for="giaTien">Giá Tiền (VND):</label>
    <input type="number" id="giaTien" name="giaTien" min="1000001" value="<%= price != null ? price : "" %>" required />

    <label for="ngayBatDau">Ngày Bắt Đầu:</label>
    <input type="date" id="ngayBatDau" name="ngayBatDau" value="<%= ngayBatDau != null ? ngayBatDau : "" %>" required />

    <label for="ngayKetThuc">Ngày Kết Thúc:</label>
    <input type="date" id="ngayKetThuc" name="ngayKetThuc" value="<%= ngayKetThuc != null ? ngayKetThuc : "" %>" required />

    <button type="submit" class="save">Lưu</button>
    <button type="button" class="cancel" onclick="window.location.href='cancel.jsp'">Hủy</button>
</form>

</body>
</html>
