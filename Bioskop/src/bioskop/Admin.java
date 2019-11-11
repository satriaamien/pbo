/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;


import java.io.Serializable;

/**
 *
 * @author ariq
 */
public class Admin extends user implements Serializable{
    
    private String kode_admin;
    public Admin(String name, String pass, String phone, String email) {
        super(name, pass, phone, email);
        this.kode_admin = String.valueOf(name.charAt(0)) + String.valueOf(phone.charAt(2)) + String.valueOf(pass.charAt(1));
    }

    public String getKode_admin() {
        return kode_admin;
    }
    

    
    
    
}
