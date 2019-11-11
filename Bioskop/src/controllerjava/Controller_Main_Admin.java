/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.main_admin;

/**
 *
 * @author ariq
 */
public class Controller_Main_Admin implements ActionListener{
    private main_admin view;
    Aplikasi apl = new Aplikasi();

    public Controller_Main_Admin() {
        view = new main_admin();
        view.setVisible(true);
        view.addListener(this);
        view.setLabel(apl.getAdm_logedin().getName());
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnFilm())) {
            new Controller_FilmAdmin();
        }
        
        if (source.equals(view.getBtnLoc())) {
            new Controller_LokasiAdmin();
        }
        
        if (source.equals(view.getBtnCin())) {
            new Controller_CinemaAdmin();
        }
        
        if (source.equals(view.getBtnStud())) {
            new Controller_studio_admin();
        }
        
        if (source.equals(view.getBtnJadwal())) {
            new Controller_penjadwalan();
        }
        
        if (source.equals(view.getBtnLogout())) {
            new Controller_Login();
        }
        view.dispose();
    }
    
    
}
