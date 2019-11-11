/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import bioskop.film_booking;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.show_barcode;

/**
 *
 * @author ariq
 */
public class Controller_show_barcode implements ActionListener{
    private show_barcode view;
    Aplikasi apl = new Aplikasi();
    film_booking fb = apl.getFilmBook();
    public Controller_show_barcode() {
        view = new show_barcode();
        view.setVisible(true);
        view.addListener(this);
        view.setJudul(fb.getJudul_film());
        view.setTgl(fb.getTgl_tayang());
        view.setSeat(fb.getNo_seat());
        view.setHarga(fb.getHarga());
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtHome())) {
            view.dispose();
            new Controller_Main_Customer();
        }
    }
    
}
