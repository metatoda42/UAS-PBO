package tugasmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Model {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    Connection koneksi;
    Statement statement;
    
    public Model(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/MyDataku?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex+"Koneksi Gagal");
        }
    }
    
    public void tambah(String nama, String alamat, String jekel, String notelp, String tl) {
    	try {

        	String  query = "INSERT INTO siswa(Nama, Alamat, Telp, TglLahir, Jeniskelamin) "
        			+ "VALUES ('"+nama+"','"+alamat+"','"+notelp+"','"+tl+"','"+jekel+"')";
       
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");

        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void save(String nama, String alamat, String jekel, String notelp, String tl) {
    	try {

        	String  query = "INSERT INTO siswa(Nama, Alamat, Telp, TglLahir, Jeniskelamin) "
        			+ "VALUES ('"+nama+"','"+alamat+"','"+notelp+"','"+tl+"','"+jekel+"')";
       
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");

        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }	
    }
    
    public void delete(int ID) {
    	try {

        	String  query = "DELETE FROM `bukualamat` WHERE `bukualamat`.`ID` ="+ID;
       
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil di Hapus");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");

        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }	
    }
    
    public void update(int ID, String nama, String alamat, String jekel, String notelp, String tl) {
    	try {

        	String  query = "UPDATE `bukualamat` SET `Nama` = '"+nama+"', `Alamat` = '"+alamat+"', `Telp` = '"+notelp+"', "
        			+ "`TglLahir` = '"+tl+"', `Jeniskelamin` = '"+jekel+"' WHERE `bukualamat`.`ID` = "+ID;
       
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil diEdit");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");

        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }	
    }
    
    public void cari(String cari) {
    	try {

        	String  query = "SELECT * FROM `bukualamat` WHERE `Nama` LIKE '"+cari+"'";
       
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");

        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }	
    }
    
    public String[][] read(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][5]; 
            
            String query = "Select * from MyDataku"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("ID");
                data[jmlData][1] = resultSet.getString("Nama");                
                data[jmlData][2] = resultSet.getString("Alamat");
                data[jmlData][3] = resultSet.getString("Telp");
                data[jmlData][4] = resultSet.getString("TglLahir");
                data[jmlData][5] = resultSet.getString("Jeniskelamin");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from MyDataku";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    
} 



