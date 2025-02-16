package codegym.c10.testbookings.controller;

import codegym.c10.testbookings.eNum.LoaiMatBang;
import codegym.c10.testbookings.eNum.TrangThai;
import codegym.c10.testbookings.model.MatBang;
import codegym.c10.testbookings.services.IMatBangServices;
import codegym.c10.testbookings.services.MatBangServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "matBangHouse", value = "/matbang")
public class PhucHopPhong extends HttpServlet {
    private final IMatBangServices iMatBangServices = new MatBangServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "list":
                showList(req, resp);
                break;
            case "add":
                showAdd(req, resp);
                break;


        }
    }

    private void showAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/add.jsp");
        rd.forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/list.jsp");
        List<MatBang> matBangs = iMatBangServices.getAllMatBangs();
        req.setAttribute("matBangs", matBangs);
        rd.forward(req,resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                handAdd(req, resp);
                break;
            case "search":
                handSearch(req,resp);
            case "delete":
                handDelete(req, resp);
                break;

        }

    }


    private void handDelete(HttpServletRequest req, HttpServletResponse resp) {
        String maMatBang = req.getParameter("maMatBang");

    }

    private void handSearch(HttpServletRequest req, HttpServletResponse resp) {
        try {

            String maMatBang = req.getParameter("maMatBang");
            int tang = Integer.parseInt(req.getParameter("tang"));
            double giaTien = Double.parseDouble(req.getParameter("giaTien"));

            List<MatBang> searchResults = iMatBangServices.finMatBangs(maMatBang, tang, giaTien);

            req.setAttribute("matBangs", searchResults);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/list.jsp");
            dispatcher.forward(req, resp);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    private void handAdd(HttpServletRequest req, HttpServletResponse resp) {
        try{

            String maMatBang = req.getParameter("maMatBang");
            String trangThai = req.getParameter("trangThai");
            int dienTich = Integer.parseInt(req.getParameter("dienTich"));
            int tang = Integer.parseInt(req.getParameter("tang"));
            String loaiMatBang = req.getParameter("loaiMatBang");
            double giaTien = Double.parseDouble(req.getParameter("giaTien"));
            LocalDate ngayBatDau = LocalDate.parse(req.getParameter("ngayBatDau"));
            LocalDate ngayKetThuc = LocalDate.parse(req.getParameter("ngayKetThuc"));


            String trangThaiuf8 = new String(trangThai.getBytes("ISO-8859-1"), "UTF-8");
            String loaiMatBanguf8 = new String(loaiMatBang.getBytes("ISO-8859-1"), "UTF-8");

            MatBang matBang = new MatBang(maMatBang, TrangThai.fromString(trangThaiuf8),dienTich,tang,LoaiMatBang.fromString(loaiMatBanguf8),giaTien,ngayBatDau,ngayKetThuc);

            iMatBangServices.addMatBang(matBang);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
