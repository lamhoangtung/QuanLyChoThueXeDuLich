/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BUL;
import com.mycompany.DAL.DALKhachHang;
import com.mycompany.DTO.KhachHang;
import java.util.List;

/**
 *
 * @author linus
 */
public class BULKhachHang {
    DALKhachHang dalKhachHang = new DALKhachHang();
    
    public List<KhachHang> layKhachHang(){
        return dalKhachHang.layKhachHang();
    }
    
    public List<KhachHang> layKhachHangTheoMa(int MaKH){
        return dalKhachHang.layKhachHangTheoMa(MaKH);
    }
    
    public List<KhachHang> layKhachHangTheoTen(String HoTen){
        return dalKhachHang.layKhachHangTheoTen(HoTen);
    }
    
    public void themKhachHang(KhachHang khachHang){
        dalKhachHang.themKhachHang(khachHang);
    }
    
    public void suaKhachHang(KhachHang khachHang){
        dalKhachHang.suaKhachHang(khachHang);
    }
        
    public void xoaKhachHang(KhachHang khachHang){
        dalKhachHang.xoaKhachHang(khachHang);
    }
}
