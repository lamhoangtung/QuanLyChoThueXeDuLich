/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BUL;
import com.mycompany.DAL.DALDonHang;
import com.mycompany.DTO.DonHang;
import java.util.List;
/**
 *
 * @author linus
 */
public class BULDonHang {
    DALDonHang dalDonHang = new DALDonHang();
    
    public List<DonHang> layDonHangTheoMa(int MaDon){
        return dalDonHang.layDonHangTheoMa(MaDon);
    }
    
    public void themDonHang(DonHang donHang){
        dalDonHang.themDonHang(donHang);
    }
}
