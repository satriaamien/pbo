/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import bioskop.*;
import com.sun.corba.se.impl.interceptors.PICurrent;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import javafx.beans.binding.Bindings;
import tampilan.*;

/**
 *
 * @author ariq
 */
public class Controller_Signup implements ActionListener{

    private signup view;
   // Aplikasi p = new Aplikasi();
    Aplikasi c1 = new Aplikasi();
    public Controller_Signup() {
        view = new signup();
        view.addListener(this);
        view.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source  = e.getSource();
        
        if (source.equals(view.getBtnSave())) {
                String name  = view.getUname();
                String pass  = view.getPass();
                String phone = view.getPhone();
                String mail  = view.getEmail();
            if (view.getRBadm()) {
                //save ke admin
                Admin adm = new Admin(name,pass,phone,mail);
                //validasi
                boolean cek = c1.getUserAdm(adm)==null; //ga kete6mu
                if (cek==true) {
                    c1.addUserAdm(adm);
                    view.clear();
                }
                
                else{
                   JOptionPane.showMessageDialog(null, "Username is already used !");
                }
            }
            
            if (view.getRBcust()) {
                //save ke customer
                Customer cust = new Customer(name,pass,phone,mail);
                boolean cek = c1.getUserCust(cust)==null; //ga nemu
                if (cek==true) {
                    c1.addUserCust(cust);
                    c1.setCust_logedin(c1.getCust_logedin());
                    view.clear();
                    
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Username is already used !");
                }
                
            }
            
        }
            
        
    
        
        if (source.equals(view.getBtnHome())) {
            view.dispose();
            new Controller_Login();
        }
        
        
    }
    
}

