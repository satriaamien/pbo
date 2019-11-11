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
import tampilan.*;

/**
 *
 * @author ariq
 */
public class Controller_Login implements ActionListener{

    private Login view;
    Aplikasi c1 = new Aplikasi();

    
    public Controller_Login() {
        view = new Login();
        view.addListener(this);
        view.setVisible(true);

    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source  = e.getSource();
        String name = view.getName();
        String pass = view.getPass();
        
        if (source.equals(view.getBtnLogin())) {
                if (view.getRBAdm()) {
                    Admin admin = new Admin(name,pass,"0888","");    
                    boolean cek = c1.getUserAdm(admin)!=null;
                    admin = c1.getUserAdm(admin);
                    if (cek==false) {
                            JOptionPane.showMessageDialog(null, "Username and password don't match, or you are not registered");
                             
                    }
                    else{
                        c1.setAdm_logedin(c1.getUserAdm(admin));
                        JOptionPane.showMessageDialog(null, "Welcome admin "+c1.getAdm_logedin().getName());
                        view.dispose();
                        new Controller_Main_Admin();       
                    }
                }
                if (view.getRBCst()) {
                    Customer cst = new Customer(name,pass,"0888","");
                    boolean cek = c1.getUserCust(cst)!=null;
                    cst = c1.getUserCust(cst);
                    if (cek==false) {
                            JOptionPane.showMessageDialog(null, "Username and password don't match, or you are not registered");
                             
                    }
                    else{
                        c1.setCust_logedin(cst); //menyimpan data yg login
                        JOptionPane.showMessageDialog(null, "Loged in");
                        view.dispose();
                        new Controller_Main_Customer();
                    }
                    
                }//endif
                
                if (!view.getRBAdm() && !view.getRBCst()) {
                    JOptionPane.showMessageDialog(null, "Select as Administrator or Customer");
                    
                }
            }//end if button
        
        if (source.equals(view.getBtnCrt())) {
                view.dispose();
                new Controller_Signup();
            }
    
    }//end method
        
        
    
}//end Class
    
