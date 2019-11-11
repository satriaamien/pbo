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
public class Film {
    private int id_film;
    private String judul_film;
    private String genre_film;
    private String durasi_film;
    private String sinopsis_film;
    
    public Film(int id_film, String judul, String genre, String durasi, String sinopsis){
        this.id_film = id_film;
        this.judul_film = judul;
        this.genre_film = genre;
        this.durasi_film = durasi;
        this.sinopsis_film = sinopsis;
    }

    public int getId_film() {
        return id_film;
    }

    public String getJudul_film() {
        return judul_film;
    }

    public String getGenre_film() {
        return genre_film;
    }

    public String getDurasi_film() {
        return durasi_film;
    }

    public String getSinopsis_film() {
        return sinopsis_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public void setJudul_film(String judul_film) {
        this.judul_film = judul_film;
    }

    public void setGenre_film(String genre_film) {
        this.genre_film = genre_film;
    }

    public void setDurasi_film(String durasi_film) {
        this.durasi_film = durasi_film;
    }

    public void setSinopsis_film(String sinopsis_film) {
        this.sinopsis_film = sinopsis_film;
    }
    
}
