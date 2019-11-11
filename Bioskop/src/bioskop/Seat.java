package bioskop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Intan Maharani
 */
public class Seat {
    private int nomor_kursi;
    private String baris_kursi;
    
    public Seat(int nomor, String baris){
        this.nomor_kursi = nomor;
        this.baris_kursi = baris;
    }

    public int getNomor_kursi() {
        return nomor_kursi;
    }

    public String getBaris_kursi() {
        return baris_kursi;
    }

    public void setNomor_kursi(int nomor_kursi) {
        this.nomor_kursi = nomor_kursi;
    }

    public void setBaris_kursi(String baris_kursi) {
        this.baris_kursi = baris_kursi;
    }
    
    
}
