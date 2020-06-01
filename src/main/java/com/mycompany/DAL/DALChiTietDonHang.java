/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAL;
import com.mycompany.DTO.DonHang;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author linus
 */
public class DALChiTietDonHang {
    
    public List<DonHang> layChiTietDonHangTheoMa(int MaDonQ){
        List<DonHang> arr = new ArrayList<DonHang>();
        Connector.openConnection();
        String query = String.format("SELECT * FROM don_hang WHERE MaDon=%d", MaDonQ);
        Statement stmt = Connector.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            int MaDon = rs.getInt("MaDon");
            int MaKH = rs.getInt("MaKH");
            String BienSo = rs.getString("BienSo");
            String DiemDi = rs.getString("DiemDi");
            String DiemDen = rs.getString("DiemDen");
            String NgayDi = rs.getString("NgayDi");
            String NgayVe = rs.getString("NgayVe");
            long Gia = rs.getLong("Gia");
            int TrangThai = rs.getInt("TrangThai");
            DonHang temp = new DonHang(MaDon, MaKH, BienSo, DiemDi, DiemDen, NgayDi, NgayVe, Gia, TrangThai);
            arr.add(temp);
        }
        Connector.closeConnection();
        return arr;
    }
    
    public void themChiTietDonHang(DonHang donHang){
        String query = String.format("INSERT INTO don_hang VALUES(%d, %d, %s, %s, %s, %s, %s, %d, %d)",
                donHang.getMaDon(),
                donHang.getMaKH(),
                donHang.getBienSo(),
                donHang.getDiemDi(),
                donHang.getDiemDen(),
                donHang.getNgayDi(),
                donHang.getNgayVe(),
                donHang.getGia(),
                donHang.getTrangThai());
        Statement stmt = Connector.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Connector.closeConnection();
    }
}
