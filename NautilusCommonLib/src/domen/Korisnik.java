/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Korisnik implements Serializable, InterfaceObjekat {

    private int korisnikID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String ime, String prezime, String username, String password) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezimeKorisnika(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return " korisnik";
    }

    @Override
    public String joinUslov() {
        return "";
    }

    @Override
    public String vratiWhereZaSelect() {
        //LIMIT number_rows
        return " WHERE username='" + username + "' AND password='" + password + "' LIMIT 1";
    }

    @Override
    public String sortiranje() {
        return "";
    }

    @Override
    public String naziviKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostiKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String wherePrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InterfaceObjekat> kreirajListu(ResultSet rs) throws Exception {
        List<InterfaceObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Korisnik(rs.getInt("korisnikID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password")));
        }
        return lista;
    }

}
