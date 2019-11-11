/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;

import java.io.Serializable;

/**
 *
 * @author satria
 */
public class film_booking implements Serializable{
    private String nama_lokasi;
    private String nama_bioskop;
    private String nomor_studio;
    private String judul_film;
    private String tgl_tayang;
    private String jam_tayang;
    private String no_seat;
    private double harga;

    public film_booking(String nama_lokasi, String nama_bioskop, String nomor_studio, String judul_film, String tgl_tayang, String jam_tayang, String no_seat, double harga) {
        this.nama_lokasi = nama_lokasi;
        this.nama_bioskop = nama_bioskop;
        this.nomor_studio = nomor_studio;
        this.judul_film = judul_film;
        this.tgl_tayang = tgl_tayang;
        this.jam_tayang = jam_tayang;
        this.no_seat = no_seat;
        this.harga = harga;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getNama_bioskop() {
        return nama_bioskop;
    }

    public void setNama_bioskop(String nama_bioskop) {
        this.nama_bioskop = nama_bioskop;
    }

    public String getNomor_studio() {
        return nomor_studio;
    }

    public void setNomor_studio(String nomor_studio) {
        this.nomor_studio = nomor_studio;
    }

    public String getJudul_film() {
        return judul_film;
    }

    public void setJudul_film(String judul_film) {
        this.judul_film = judul_film;
    }

    public String getTgl_tayang() {
        return tgl_tayang;
    }

    public void setTgl_tayang(String tgl_tayang) {
        this.tgl_tayang = tgl_tayang;
    }

    public String getJam_tayang() {
        return jam_tayang;
    }

    public void setJam_tayang(String jam_tayang) {
        this.jam_tayang = jam_tayang;
    }

    public String getNo_seat() {
        return no_seat;
    }

    public void setNo_seat(String no_seat) {
        this.no_seat = no_seat;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    
        
}
