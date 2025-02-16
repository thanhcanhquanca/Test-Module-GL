<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tìm Mặt Bằng Cho Thuê</title>
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
    button.search {
      background-color: #008CBA;
      color: white;
    }
    button.reset {
      background-color: #f44336;
      color: white;
      margin-left: 10px;
    }
  </style>
</head>
<body>
<h1>Tìm Mặt Bằng Cho Thuê</h1>

<form id="formTimKiem" action="matbang?action=search" method="post">
  <label for="maMatBang">Mã Mặt Bằng:</label>
  <input type="text" id="maMatBang" name="maMatBang" placeholder="Nhập mã mặt bằng..." />

  <label for="tang">Tầng:</label>
  <select id="tang" name="tang">
    <option value="">-- Chọn Tầng --</option>
    <% for (int i = 1; i <= 15; i++) { %>
    <option value="<%= i %>">Tầng <%= i %></option>
    <% } %>
  </select>

  <label for="giaTien">Giá Tiền Tối Đa (VND):</label>
  <input type="number" id="giaTien" name="giaTien" placeholder="Nhập giá tối đa..." />

  <button type="submit" class="search">Tìm Kiếm</button>
</form>

<div>
  <table border="1px">
    <tr>
      <td>Mã Mặt Bằng</td>
      <td>Trạng Thái</td>
      <td>Diện Tích</td>
      <td>Tầng</td>
      <td>Loại Mặt Bằng</td>
      <td>Giá Tiền</td>
      <td>Ngày Bắt Đầu</td>
      <td>Ngày Kết Thúc</td>
    </tr>

    <c:forEach items="${matBangs}" var="c">
      <tr>
        <td>${c.maMatBang}</td>
        <td>${c.trangThai}</td>
        <td>${c.dienTich}</td>
        <td>${c.tang}</td>
        <td>${c.loaiMatBang}</td>
        <td>${c.price}</td>
        <td>${c.ngayBatDau}</td>
        <td>${c.ngayKetThuc}</td>
        <td>Edit</td>

        <td>
          <form action="matbang?action=edit" method="post" style="display: inline">
            <input type="hidden" name="editMatbang" value="">

          </form>
        </td>
        <td>
          <form action="matbang?action=delete" method="post" style="display:inline;">
            <input type="hidden" name="maMatBang" value="${c.maMatBang}">
            <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa không?');">Delete</button>
          </form>
        </td>

      </tr>

    </c:forEach>

  </table>
</div>

</body>
</html>
