/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.view_profile;

/**
 *
 * @author ariq
 */
public class Controller_view_profile implements ActionListener{
    private view_profile view;
    Aplikasi apl = new Aplikasi();
    public Controller_view_profile() {
        view = new view_profile();
        view.setVisible(true);
        view.addListener(this);
        view.setAllText(apl.getCust_logedin());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnBack())) {
            view.dispose();
            new Controller_Main_Customer();
        }
    }
    
}
