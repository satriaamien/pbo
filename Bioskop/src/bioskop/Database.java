/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;

/**
 *
 * @author Intan Maharani
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Database {
    private final String server = "jdbc:mysql://localhost:3306/bioskop";
    private final String dbuser = "root";
    private final String dbpass = "";
    private Statement statement = null;
    private Connection connection = null;
    
    public Database() {
        
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "JDBC Driver Error", JOptionPane.WARNING_MESSAGE);
        }         
        
        try {
            connection = DriverManager.getConnection(server,dbuser,dbpass);
            statement = connection.createStatement();
        } catch (SQLException e){
            throw new IllegalArgumentException("Kesalahan Koneksi");
        }
    }
    
    public void disconnect(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertLokasi(Location l) {
        try {
            String query = "insert into Location(id_lokasi,nama_lokasi,jumlah_bioskop) values"
                    + "('" + l.getId_location() + "', "
                    + "'" + l.getName_location() + "', "
                    + "'5')";
            //bandung, jakarta, jogjakarta, surabaya, bali
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cek lagi id lokasi, mungkin sudah terdaftar");
        }
    }
    
    public void insertCinema(Cinema c) {
        try {
            String query = "insert into Cinema(id_cinema,name_cinema,jumlah_film,jumlah_studio,jumlah_jadwal) values"
                    + "('" + c.getId_cinema() + "', "
                    + "'" + c.getName_cinema() + "', "
                    + "'5',"
                    + "'4',"
                    + "'10')";
            //tsm, grand indonesia,
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cek lagi id cinema, mungkin sudah terdaftar");
        }
    }
    
    public void insertFilm(Film f) {
        try {
            String query = "insert into Film(id_film,judul_film,genre_film,durasi_film,sinopsis_film) values"
                    + "('" + f.getId_film() +  "', "
                    + "'" + f.getJudul_film() + "', "
                    + "'" + f.getGenre_film() + "',"
                    + "'" + f.getDurasi_film()+ "',"
                    + "'" + f.getSinopsis_film() + "')";
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cek lagi id film, mungkin sudah terdaftar");
        }
    }
    
    public void insertSeat(Seat s) {
        try {
            String query = "insert into Seat(nomor_kursi,baris_kursi) values"
                    + "('" + s.getNomor_kursi() + "', "
                    + "'" + s.getBaris_kursi() + "')";
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Coba Lagi");
        }
    }
    
    public void insertJadwal(jadwal_film x){
        try {
            String query = "insert into jadwal_film(id_jadwal,nama_lokasi,nama_bioskop,nomor_studio,judul_film,tgl_tayang,harga,jamtayang) values"
                    + "('" + x.getId_jadwal() + "'"
                    + ",'" + x.getNama_lokasi()+ "'"
                    + ",'" + x.getNama_bioskop()+ "'"
                    + ",'" + x.getNomor_studio()+ "'"
                    + ",'" + x.getJudul_film() +"'"
                    + ",'" + x.getTgl_tayang() + "'"
                    + "," + x.getHarga()+",'"
                    + x.getJamtayang()+"')";
            statement.executeUpdate(query);
            System.out.println("dnkjnfwefb");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public ArrayList<jadwal_film> loadJadwal(){
        ArrayList<jadwal_film> list = new ArrayList();
        try {
            ResultSet rs = statement.executeQuery("Select * from jadwal_film");
            while (rs.next()) {
                jadwal_film x = new jadwal_film(rs.getString("id_jadwal"),rs.getString("nama_lokasi"),rs.getString("nama_bioskop"),
                        rs.getString("nomor_studio"),rs.getString("judul_film"),rs.getString("tgl_tayang"),rs.getInt("harga"),rs.getString("jamtayang"));
                list.add(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Error Load jadwal", JOptionPane.WARNING_MESSAGE);
        }
        
        
        return list;
    }
    
    public ArrayList<Location> loadLokasi() {
        try {
            ArrayList<Location> listLokasi = new ArrayList<>();
            String query = "select * from Location";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Location t = new Location(rs.getString("nama_lokasi"),rs.getInt("id_lokasi"));
                listLokasi.add(t);
            }
            return listLokasi;

        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan");
        }
    }
    
     public ArrayList<Cinema> loadCinema() {
        try {
            ArrayList<Cinema> listCinema = new ArrayList<>();
            String query = "select * from Cinema";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Cinema c = new Cinema(rs.getString("name_cinema"),rs.getInt("id_cinema"));
                listCinema.add(c);
            }
            return listCinema;

        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan");
        }
    }
     
     public ArrayList<Film> loadFilm() {
        try {
            ArrayList<Film> listFilm = new ArrayList<>();
            String query = "select * from Film";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Film f = new Film(rs.getInt("id_film"),rs.getString("judul_film"),rs.getString("genre_film"),rs.getString("durasi_film"),rs.getString("sinopsis_film"));
                listFilm.add(f);
            }
            return listFilm;

        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan");
        }
    }
     
    public ArrayList<Seat> loadSeat() {
        try {
            ArrayList<Seat> listSeat = new ArrayList<>();
            String query = "select * from Seat";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Seat a = new Seat(rs.getInt("nomor_kursi"),rs.getString("baris_kursi"));
                listSeat.add(a);
            }
            return listSeat;

        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan");
        }
    }
    
//---------------------------------------bagian-----------------------------------------------------------------

    public byte[] toBytes(Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "Error Convert", "Error", JOptionPane.ERROR_MESSAGE);
        }
 
        return baos.toByteArray();
    }
        
    public Object toObject(byte[] bytes) throws IOException, ClassNotFoundException{
        Object obj = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }

    public void saveAdmin(Admin x){ 
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into object_admin values(?,?)");
            stmt.setString(1, x.getName());
            stmt.setBytes(2, toBytes(x));
            
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Admin> LoadAdmin(){
        ArrayList<Admin> list= new ArrayList();
        try {
            ResultSet rs = statement.executeQuery("select * from object_admin");
            while (rs.next()) {
                Object o = toObject(rs.getBytes(2));
                Admin adm = (Admin) o;
                list.add(adm);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public void saveCustomer(Customer x){ 
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into object_customer values(?,?)");
            stmt.setString(1, x.getName());
            stmt.setBytes(2, toBytes(x));
            
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void updateCustomer(Customer x){
        try {
            PreparedStatement stmt = connection.prepareStatement("update object_customer set object_customer = ? where 	id_customer = ?");
            stmt.setBytes(1, toBytes(x));
            stmt.setString(2, x.getName());
            
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error update", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    
    public ArrayList<Customer> LoadCustomer(){
        ArrayList<Customer> list= new ArrayList();
        try {
            ResultSet rs = statement.executeQuery("select * from object_customer");
            while (rs.next()) {
                Object o = toObject(rs.getBytes(2));
                Customer cust = (Customer) o;
                list.add(cust);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
       
    
    public void saveStudio(Studio x){
        try {
            String query  = "insert into studio values('"+x.getNomor_theater()+"')";
            statement.execute(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Save studio");
        }
    }
    
    
    public ArrayList<Studio> loadStudio(){
        ArrayList<Studio> list = new ArrayList();
        ResultSet rs;
        try {
            rs = statement.executeQuery("Select * from studio");
            while (rs.next()) {
                Studio s = new Studio(rs.getString("nomor_theater"));
                list.add(s);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return list;
    }
    
}
