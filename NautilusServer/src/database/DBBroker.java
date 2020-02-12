/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import properties.PropertiesRead;
import domen.InterfaceObjekat;

/**
 *
 * @author User
 */
public class DBBroker {
    
    Connection konekcija;
    
    
    
    public void ucitajDrajver() throws ClassNotFoundException{
        Class.forName(PropertiesRead.getPr().getDriver());
    }
    
    public void otvoriKonekciju() throws SQLException{
        konekcija = DriverManager.getConnection(PropertiesRead.getPr().getUrl(), PropertiesRead.getPr().getUser(), PropertiesRead.getPr().getPassword());
        konekcija.setAutoCommit(false);
    }
    
    public void zatvoriKonekciju() throws SQLException{
        konekcija.close();
    }
    
    public void commit() throws SQLException{
        konekcija.commit();
    }
    
    public void rollback() throws SQLException{
        konekcija.rollback();
    }
    
    public ResultSet vrati(InterfaceObjekat domenskiObjekat) throws SQLException{
        String upit = "SELECT * FROM " + domenskiObjekat.nazivTabele() + " "+domenskiObjekat.joinUslov() + " " + domenskiObjekat.vratiWhereZaSelect() + " "+domenskiObjekat.sortiranje();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        return s.executeQuery(upit);
    }
    public int unesi(InterfaceObjekat domenskiObjekat) throws SQLException{
        String upit = "INSERT INTO "+domenskiObjekat.nazivTabele() +"("+domenskiObjekat.naziviKolona()+") VALUES ("+domenskiObjekat.vrednostiKolona()+")";
        System.out.println(upit);
        //Statement s = konekcija.createStatement();
        //s.executeUpdate(upit);
                PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                int id = -1;
                if(rs.next()){
                    id = rs.getInt(1);
                }
                return id;
    }
    public void izmeni(InterfaceObjekat domenskiObjekat) throws SQLException{
        String upit = "UPDATE "+domenskiObjekat.nazivTabele() +"SET "+domenskiObjekat.vratiVrednostiUpdate()+" WHERE "+domenskiObjekat.wherePrimarniKljuc();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
    public void obrisi(InterfaceObjekat domenskiObjekat) throws SQLException{
        String upit = "DELETE FROM "+domenskiObjekat.nazivTabele() +" WHERE "+domenskiObjekat.wherePrimarniKljuc();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
    public int max(InterfaceObjekat domenskiObjekat) throws SQLException{
        String upit = "SELECT max("+ domenskiObjekat.maxKljuc() +") as max FROM " + domenskiObjekat.nazivTabele();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        int max = 0;
        while (rs.next()) {            
            max = rs.getInt("max");
        }
        return max;
    }
    
    
}
