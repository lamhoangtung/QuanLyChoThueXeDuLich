/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAL;
import com.mycompany.DTO.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linus
 */
public class DALKhachHang {
    public List<KhachHang> layKhachHang(){
        try {
            List<KhachHang> arr = new ArrayList<KhachHang>();
            String query = "SELECT * FROM khach_hang";
            Connector.openConnection();
            Statement stmt = Connector.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int MaKH = rs.getInt("MaKH");
                String HoTen = rs.getString("HoTen");
                long SDT = rs.getLong("SDT");
                String DiaChi = rs.getString("DiaChi");
                int SoLanDatXe = rs.getInt("SoLanDatXe");
                KhachHang temp = new KhachHang(MaKH, HoTen, SDT, DiaChi, SoLanDatXe);
                arr.add(temp);
            }
            Connector.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<KhachHang> layKhachHangTheoMa(int MaKHQ){
        try {
            List<KhachHang> arr = new ArrayList<KhachHang>();
            String query = String.format("SELECT * FROM khach_hang WHERE MaKH LIKE %s + '%'", MaKHQ);
            Connector.openConnection();
            Statement stmt = Connector.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int MaKH = rs.getInt("MaKH");
                String HoTen = rs.getString("HoTen");
                long SDT = rs.getLong("SDT");
                String DiaChi = rs.getString("DiaChi");
                int SoLanDatXe = rs.getInt("SoLanDatXe");
                KhachHang temp = new KhachHang(MaKH, HoTen, SDT, DiaChi, SoLanDatXe);
                arr.add(temp);
            }
            Connector.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public List<KhachHang> layKhachHangTheoTen(String HoTenQ){
        try {
            List<KhachHang> arr = new ArrayList<KhachHang>();
            String query = String.format("SELECT * FROM khach_hang WHERE HoTen LIKE %s + '%'", HoTenQ);
            Connector.openConnection();
            Statement stmt = Connector.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int MaKH = rs.getInt("MaKH");
                String HoTen = rs.getString("HoTen");
                long SDT = rs.getLong("SDT");
                String DiaChi = rs.getString("DiaChi");
                int SoLanDatXe = rs.getInt("SoLanDatXe");
                KhachHang temp = new KhachHang(MaKH, HoTen, SDT, DiaChi, SoLanDatXe);
                arr.add(temp);
            }
            Connector.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void themKhachHang(KhachHang khachHang){
        try {
            String query = String.format("INSERT INTO khach_hang VALUES('%d', '%s', '%d', '%s', '%d')",
                    khachHang.getMaKH(),
                    khachHang.getHoTen(),
                    khachHang.getSDT(),
                    khachHang.getDiaChi(),
                    khachHang.getSoLanDatXe());
            Connector.openConnection();
            Statement stmt = Connector.conn.createStatement();
            stmt.execute(query);
            Connector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void suaKhachHang(KhachHang khachHang){
        try {
            String query = String.format("UPDATE khach_hang SET HoTen=%s, SDT=%d, DiaChi=%s, SoLanDatXe=%d where MaKH=%s",
                    khachHang.getHoTen(),
                    khachHang.getSDT(),
                    khachHang.getDiaChi(),
                    khachHang.getSoLanDatXe(),
                    khachHang.getMaKH());
            Connector.openConnection();
            Statement stmt = Connector.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Connector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void xoaKhachHang(KhachHang khachHang){
        try {
            String query = String.format("DELETE FROM khach_hang where MaKH=%s", khachHang.getMaKH());
            Connector.openConnection();
            Statement stmt = Connector.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Connector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
