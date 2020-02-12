/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PDVStopa implements Serializable, InterfaceObjekat{
    private int pdvID;
    private String naziv;
    private double iznos;

    public PDVStopa() {
    }

    public PDVStopa(int pdvID, String naziv, double iznos) {
        this.pdvID = pdvID;
        this.naziv = naziv;
        this.iznos = iznos;
    }

    public int getPdvID() {
        return pdvID;
    }

    public void setPdvID(int pdvID) {
        this.pdvID = pdvID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public String nazivTabele() {
        return " pdvstopa";
    }

    @Override
    public String joinUslov() {
        return "";
    }

    @Override
    public String vratiWhereZaSelect() {
        return "";
    }

    @Override
    public String sortiranje() {
        return "";
    }

    @Override
    public String naziviKolona() {
        return "";
    }

    @Override
    public String vrednostiKolona() {
        return "";
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
            lista.add(new PDVStopa(rs.getInt("PdvStopaID"), rs.getString("Naziv"), rs.getInt("Iznos")));
        }
        return lista;
    }
    
    
}
