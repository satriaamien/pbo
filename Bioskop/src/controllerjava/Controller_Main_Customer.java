/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.main_customer;
import tampilan.now_playing;

/**
 *
 * @author ariq
 */
public class Controller_Main_Customer implements ActionListener{
    private main_customer view;
    Aplikasi apl = new Aplikasi();

    public Controller_Main_Customer() {
        view = new main_customer();
        view.setVisible(true);
        view.addListener(this);
        view.setLabel(apl.getCust_logedin().getName());
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogOut())) {
            new Controller_Login();
        }
        
        if (source.equals(view.getBtnProf())) {
            //new controller profile
            new Controller_view_profile();
        }
        
        if (source.equals(view.getBtnOrder())) {
            //new controller Order
            new Controller_LokasiCustomer();
        }
        
        if (source.equals(view.getBtnShowSchedule())) {
            new Controller_now_playing();
        }
        
        if (source.equals(view.getBtnTopUp())) {
            //new controller top_up
            new Controller_view_top_up();
        }
        view.dispose();
    }
    
}
