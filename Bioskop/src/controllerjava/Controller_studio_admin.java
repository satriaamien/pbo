/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import bioskop.Studio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tampilan.Studio_admin;

/**
 *
 * @author ariq
 */
public class Controller_studio_admin implements ActionListener{
    private Studio_admin view;
    Aplikasi apl = new Aplikasi();

    public Controller_studio_admin() {
        view = new Studio_admin();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnExit())) {
            view.dispose();
            new Controller_Main_Admin();
        }
        
        if (source.equals(view.getBtnSave())) {
            String no = view.getNumber();
            Studio s = new Studio(no);
            apl.addStudio(s);
            view.clear();
        }
    }
    
    
}
