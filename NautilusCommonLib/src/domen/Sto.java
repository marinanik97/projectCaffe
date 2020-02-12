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
import java.util.Objects;

/**
 *
 * @author User
 */
public class Sto implements Serializable, InterfaceObjekat{
    private int stoID;
    private String pozicijaStola;
    private int brojLjudi;
    private byte status;

    public Sto() {
    }
    
    public Sto(int stoID, String pozicijaStola, int brojLjudi, byte status) {
        this.stoID = stoID;
        this.pozicijaStola = pozicijaStola;
        this.brojLjudi = brojLjudi;
        this.status = status;
    }

    public byte isStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getStoID() {
        return stoID;
    }

    public void setStoID(int stoID) {
        this.stoID = stoID;
    }

    public String getBrojStola() {
        return pozicijaStola;
    }

    public void setBrojStola(String pozicijaStola) {
        this.pozicijaStola = pozicijaStola;
    }

    public int getBrojLjudi() {
        return brojLjudi;
    }

    public void setBrojLjudi(int brojLjudi) {
        this.brojLjudi = brojLjudi;
    }

    @Override
    public String toString() {
        return pozicijaStola;
    }

    @Override
    public String nazivTabele() {
        return " sto ";
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
        return " status = '"+status+"'";
    }

    @Override
    public String wherePrimarniKljuc() {
        return " stoid = '"+stoID+"'";
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InterfaceObjekat> kreirajListu(ResultSet rs) throws Exception {
        List<InterfaceObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new Sto(rs.getInt("StoID"), rs.getString("PozicijaStola"), rs.getInt("BrojLjudi"), rs.getByte("Status")));
        }
        return lista;   
    }

    public String getPozicijaStola() {
        return pozicijaStola;
    }

    public void setPozicijaStola(String pozicijaStola) {
        this.pozicijaStola = pozicijaStola;
    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sto other = (Sto) obj;
       
        if (!Objects.equals(this.pozicijaStola, other.pozicijaStola)) {
            return false;
        }
//        if (!Objects.equals(this.brojLjudi, other.brojLjudi)) {
//            return false;
//        }
//        if (!Objects.equals(this.status, other.status)) {
//            return false;
//        }
//        if (!Objects.equals(this.stoID, other.stoID)) {
//            return false;
//        }
        return true;
    }

    
    
    
}
