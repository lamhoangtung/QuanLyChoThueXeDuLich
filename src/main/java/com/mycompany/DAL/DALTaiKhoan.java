/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAL;

import com.mycompany.DTO.TaiKhoan;
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
public class DALTaiKhoan {
    
     public List<TaiKhoan> getListTaiKhoan(){
        try {
            List<TaiKhoan> arr = new ArrayList<TaiKhoan>();
            String query = "SELECT * FROM tai_khoan";
            Connector.openConnection();
            Statement stmt = Connector.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String TenDangNhap = rs.getString("TenDangNhap");
                String MatKhau = rs.getString("MatKhau");
                TaiKhoan temp = new TaiKhoan(TenDangNhap, MatKhau);
                arr.add(temp);
            }
            Connector.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
