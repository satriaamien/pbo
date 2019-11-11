/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 *
 * @author OWNER
 */
public class Aplikasi {
    public static ArrayList<Location> listLokasi;
    public static ArrayList<Cinema> listCinema;
    public static ArrayList<Film> listFilm;
    public static ArrayList<Seat> listSeat;

    public static ArrayList<Admin> listAdm = new ArrayList();
    public static ArrayList<Customer> listCust = new ArrayList();
    public static Admin adm_logedin;
    public static Customer cust_logedin;    
    
    public static ArrayList<jadwal_film> listJadwal = new ArrayList();
    public static ArrayList<Studio> listStudio = new ArrayList();
    Database db= new Database();
    
    public static String tampungLokasi;
    public static String tampungCinema;
    
    public static film_booking tampungBook;
    
    
    public Aplikasi(){
        listLokasi = db.loadLokasi();
        listCinema = db.loadCinema();
        listFilm = db.loadFilm();
        listSeat = db.loadSeat();
        this.listAdm = db.LoadAdmin(); //load
        this.listJadwal = db.loadJadwal();
        this.listStudio = db.loadStudio();
        this.listCust = db.LoadCustomer();
    }
    
    public void setTampungBook(film_booking x){
        this.tampungBook = x;
    }
    
    public film_booking getFilmBook(){
        return this.tampungBook;
    }
    
    public String getTampungLokasi(){
        return tampungLokasi;
    }
    
    public String getTampungCinema(){
        return tampungCinema;
    }
    
    public void setTampungLokasi(String x){
        this.tampungLokasi = x;
    }

    public void setTampungCinema(String x){
        this.tampungCinema = x;
    }
    
    public Location getLokasi(String nama_lokasi) {
        for (Location t : listLokasi) {
            if (t.getName_location().equals(nama_lokasi)) {
                return t;
            }
        }
        return null;
    }
    
    public Cinema getCinema(String nama_cinema) {
        for (Cinema c : listCinema) {
            if (c.getName_cinema().equals(nama_cinema)) {
                return c;
            }
        }
        return null;
    }
    
    public Film getFilm(String judul) {
        for (Film f : listFilm) {
            if (f.getJudul_film().equals(judul)) {
                return f;
            }
        }
        return null;
    }
    
    public Seat getSeat(String bariskursi) {
        for (Seat s : listSeat) {
            if (s.getBaris_kursi().equals(bariskursi)) {
                return s;
            }
        }
        return null;
    }
    
    public void addLokasi(String nama_lokasi, int id_lokasi) {
        if (getLokasi(nama_lokasi) != null) {
            throw new IllegalArgumentException ("nama telah digunakan!");
        }
        Location t = new Location(nama_lokasi,id_lokasi);
        listLokasi.add(t);
        db.insertLokasi(t);
    }
    
    public Studio getStudio(Studio s){
        for (Studio x : listStudio) {
            if (x.getNomor_theater().equals(s.getNomor_theater())) {
               return x;    
            }
        }
        return null;
    }
    public void addStudio(Studio x){
        if (getStudio(x)!=null) {
            JOptionPane.showMessageDialog(null, "Duplicate data", "Error Add", JOptionPane.WARNING_MESSAGE);
        }
        else if(getStudio(x)==null) {
        listStudio.add(x);
        db.saveStudio(x);
        }
    }
    
    public ArrayList<String> getStudioList(){
        ArrayList<String> tampung = new ArrayList();
        for (Studio x : listStudio) {
            tampung.add(x.getNomor_theater());
        }
        return tampung;
    }
    
    public ArrayList<String> getLocationlist(){
        ArrayList<String> tampung = new ArrayList();
        for (Location x : listLokasi){
            tampung.add(x.getName_location());
        }
        return tampung;
    }
    
    public void addCinema(String nama_cinema, int id_cinema) {
        if (getCinema(nama_cinema) != null) {
            throw new IllegalArgumentException ("nama telah digunakan!");
        }
        Cinema c = new Cinema(nama_cinema,id_cinema);
        listCinema.add(c);
        db.insertCinema(c);
    }
    
    public ArrayList<String> getCinemalist(){
        ArrayList<String> tampung = new ArrayList();
        for (Cinema x : listCinema){
            tampung.add(x.getName_cinema());
        }
        return tampung;
    }
    
    public void addFilm(int id_film,String judul, String genre, String durasi, String sinopsis) {
        if (getFilm(judul) != null) {
            throw new IllegalArgumentException ("Judul telah digunakan!");
        }
        Film f = new Film(id_film,judul,genre,durasi,sinopsis);
        listFilm.add(f);
        db.insertFilm(f);
    }
    
    public ArrayList<String> getFilmlist(){
        ArrayList<String> tampung = new ArrayList();
        for (Film x : listFilm){
            tampung.add(x.getJudul_film());
        }
        return tampung;
    }
    
    public void addSeat(int nomor_kursi,String baris_kursi) {
        if (getSeat(baris_kursi) != null) {
            throw new IllegalArgumentException ("baris dan nomor telah digunakan!");
        }
        Seat s = new Seat(nomor_kursi,baris_kursi);
        listSeat.add(s);
        db.insertSeat(s);
    }
    
//--------------------------------------------------------------------------------------------------------------
    
    public Admin getAdm_logedin() {
        return adm_logedin;
    }

    public void setAdm_logedin(Admin adm_logedin) {
        Aplikasi.adm_logedin = adm_logedin;
    }

    public Customer getCust_logedin() {
        return cust_logedin;
    }

    public void setCust_logedin(Customer cust_logedin) {
        Aplikasi.cust_logedin = cust_logedin;
    }
    
    
    public jadwal_film getJadwalFilm(jadwal_film x){
        for (jadwal_film o : listJadwal) {
            if (o.getId_jadwal().equals(x.getId_jadwal())) { //cek duplikat
                return o;
            }
        }
        return null;
    }
    
    public void addJadwalFilm(jadwal_film x){
        if (getJadwalFilm(x)!=null) {
            JOptionPane.showMessageDialog(null, "Duplicate data", "Error Add", JOptionPane.WARNING_MESSAGE);
        }
        
        else {
            listJadwal.add(x);
            db.insertJadwal(x);
        }
    
    }
    
    public Admin getUserAdm(Admin x){
        for (Admin y : listAdm) {
            if ( y.getName().equals(x.getName()) && y.getPass().equals(x.getPass())) {
                return y;
            }
        
        }
        return null;
    }
    
    public Customer getUserCust(Customer x){
        for (Customer y : this.listCust) {
            if ( y.getName().equals(x.getName()) && y.getPass().equals(x.getPass())) {
                return y;
            }
        
        }
        return null;
    }
    
    public void addUserAdm(Admin x){
        if (getUserAdm(x)!=null) {
            JOptionPane.showMessageDialog(null, "Username is already used");
        }
        else{
            listAdm.add(x);
            db.saveAdmin(x);
            //dbinseert
        }
    }
    
    
    public void addUserCust(Customer x){
        if (getUserCust(x)!=null) {
            JOptionPane.showMessageDialog(null, "Username is already used");
        }
        else{
            listCust.add(x);
            db.saveCustomer(x);
        }
    }
    
    public void updateUserCust(Customer x){
        if (getUserCust(x)==null) {
            JOptionPane.showMessageDialog(null, "Data not found, can not update", "error", JOptionPane.WARNING_MESSAGE);
        }
        else{
            for (Customer w : listCust) {
                if (w.getName()==x.getName()) {
                    x = w;  
                }
                
            }
            db.updateCustomer(x);
        }
    
    }
     

    
}
