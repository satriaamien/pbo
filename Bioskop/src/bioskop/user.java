/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;

import com.sun.xml.internal.ws.developer.Serialization;
import java.io.Serializable;

/**
 *
 * @author ariq
 */
public class user implements Serializable{
    protected String name;
    protected String pass;
    protected String phone;
    protected String email;


    public user(String name, String pass, String phone, String email) {
        
        this.name = name;
        this.pass = pass;
        this.phone = phone;
        this.email = email;

    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
