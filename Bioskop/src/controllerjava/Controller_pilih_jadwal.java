/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import bioskop.Database;
import bioskop.film_booking;
import bioskop.jadwal_film;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tampilan.pilih_jadwal;

/**
 *
 * @author ariq
 */
public class Controller_pilih_jadwal extends MouseAdapter implements ActionListener,MouseMotionListener{
    private pilih_jadwal view;
    Aplikasi apl = new Aplikasi();
    Database db = new Database();
    ArrayList<jadwal_film> jadwal = loadDaftarJadwalSort(apl.getTampungLokasi(), apl.getTampungCinema());
    jadwal_film cs = null;
    public Controller_pilih_jadwal() {
        view = new pilih_jadwal();
        view.setVisible(true);
        view.addListener(this);
        view.addMouseAdapter(this);
        view.setDaftarJadwal(getDaftarjadwal());
    }
    
    public ArrayList<jadwal_film> loadDaftarJadwalSort(String lokasi , String Cinema){
        ArrayList<jadwal_film> list = new ArrayList();
            for (jadwal_film x : db.loadJadwal()) {
                if (x.getNama_lokasi().equals(lokasi) && x.getNama_bioskop().equals(Cinema)) {
                    list.add(x);
                }
            }
           return list;
    }
    
    public String[] getDaftarjadwal(){
        String[] j = new String[jadwal.size()];
        for (int i = 0; i < j.length; i++) {
            j[i] = jadwal.get(i).getJudul_film();
        }
    
        return j;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())) {
            view.dispose();
            new Controller_Main_Customer();
        }
        if (source.equals(view.getBtnOrder())) {
             String loc = apl.getTampungLokasi();
             String cin = apl.getTampungCinema();
             String num = cs.getNomor_studio();
             String tit = cs.getJudul_film();
             String tgl = cs.getTgl_tayang();
             String jam = cs.getJamtayang();
             String seat = view.getSeat();
             double hrg = cs.getHarga();
             
            film_booking fb = new film_booking(loc,cin,num,tit,tgl,jam,seat,hrg);
            if (apl.cust_logedin.getBalance() < fb.getHarga()) {
                JOptionPane.showMessageDialog(null, "Saldo tidak cukup", "Transaction abort", JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Pemesanan Sukses", "", JOptionPane.PLAIN_MESSAGE);
                apl.setTampungBook(fb);
                apl.cust_logedin.add_film(fb);
                apl.updateUserCust(apl.cust_logedin);
                new Controller_show_barcode();
                view.dispose();
                
                
            }
         }
    }
    
    @Override
    public void mousePressed (MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getList())) {
            String s = view.getSelectedJadwal();
            for (jadwal_film w : jadwal) {
                if (w.getJudul_film().equals(s)) {
                    cs = w;
                }
            }
            view.setTextDes(cs);
        }//end list pressed
    }
    


    
}//end of class
