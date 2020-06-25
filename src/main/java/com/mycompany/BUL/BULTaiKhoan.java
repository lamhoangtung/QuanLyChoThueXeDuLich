/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.BUL;

import com.mycompany.DAL.DALTaiKhoan;
import com.mycompany.DTO.TaiKhoan;
import java.util.List;

/**
 *
 * @author linus
 */
public class BULTaiKhoan {
    DALTaiKhoan dalTaiKhoan = new DALTaiKhoan();
    
    public List<TaiKhoan> getListTaiKhoan(){
        return dalTaiKhoan.getListTaiKhoan();
    }
}
