/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;
import java.util.*;
/**
 *
 * @author satria
 */
public class jadwal_film {
    private String id_jadwal;
    private String nama_lokasi;
    private String nama_bioskop;
    private String nomor_studio;
    private String judul_film;
    private String tgl_tayang;
    private double harga;
    private String jamtayang;

    public jadwal_film(String id_jadwal, String nama_lokasi, String nama_bioskop, String nomor_studio, String judul_film, String tgl_tayang, int harga, String jamtayang) {
        this.id_jadwal = id_jadwal;
        this.nama_lokasi = nama_lokasi;
        this.nama_bioskop = nama_bioskop;
        this.nomor_studio = nomor_studio;
        this.judul_film = judul_film;
        this.tgl_tayang = tgl_tayang;
        this.harga = harga;
        this.jamtayang = jamtayang;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
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

    public double getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getJamtayang() {
        return jamtayang;
    }

    public void setJamtayang(String jamtayang) {
        this.jamtayang = jamtayang;
    }


     
}//endclass


