package codegym.c10.testbookings.services;

import codegym.c10.testbookings.model.MatBang;

import java.util.List;

public interface IMatBangServices {
    boolean addMatBang(MatBang matBang);
    List<MatBang> getAllMatBangs();
    boolean deleteMaMatBang(String maMatBang);
    boolean updateMatBang(MatBang matBang);
    List<MatBang> finMatBangs(String maMatBang,Integer tang,Double price);

}
