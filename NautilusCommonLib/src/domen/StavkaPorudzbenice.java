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
public class StavkaPorudzbenice implements Serializable, InterfaceObjekat {

    private int rb;
    private int kolicina;
    private double ukupnaCenaSaPdvom;
    private double ukupnaCenaBezPdva;
    private Artikal artikal;
    private Porudzbenica porudzbenica;

    public StavkaPorudzbenice() {
    }

    public StavkaPorudzbenice(int rb, int kolicina, double ukupnaCenaSaPdvom, double ukupnaCenaBezPdva, Artikal artikal, Porudzbenica porudzbenica) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.ukupnaCenaSaPdvom = ukupnaCenaSaPdvom;
        this.ukupnaCenaBezPdva = ukupnaCenaBezPdva;
        this.artikal = artikal;
        this.porudzbenica = porudzbenica;
    }

    
    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getUkupnaCenaSaPdvom() {
        return ukupnaCenaSaPdvom;
    }

    public void setUkupnaCenaSaPdvom(double ukupnaCenaSaPdvom) {
        this.ukupnaCenaSaPdvom = ukupnaCenaSaPdvom;
    }

    public double getUkupnaCenaBezPdva() {
        return ukupnaCenaBezPdva;
    }

    public void setUkupnaCenaBezPdva(double ukupnaCenaBezPdva) {
        this.ukupnaCenaBezPdva = ukupnaCenaBezPdva;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    @Override
    public String nazivTabele() {
        return " StavkaPorudzbenice";
    }

    @Override
    public String joinUslov() {
        return "  sp JOIN porudzbenica p ON (sp.porudzbenicaid=p.porudzbenicaid) JOIN artikal a \n"
                + "ON (sp.artikalid=a.artikalid) JOIN korisnik k ON (a.korisnikid=k.korisnikid) JOIN pdvstopa ps ON (a.pdvstopaid=ps.pdvstopaid)";
    }

    @Override
    public String vratiWhereZaSelect() {
        return "WHERE sp.porudzbenicaid= "+porudzbenica.getPorudzbenicaID();
    }

    @Override
    public String sortiranje() {
        return "";
    }

    @Override
    public String naziviKolona() {
        return " porudzbenicaid, rb, kolicina, ukupnacenasapdvom, ukupnacenabezpdva, artikalid";
    }

    @Override
    public String vrednostiKolona() {
        return porudzbenica.getPorudzbenicaID()+ "," + rb + ", "+ kolicina+", "+ukupnaCenaSaPdvom+", "+ ukupnaCenaBezPdva+", "+artikal.getArtikalid()+"";
    }

    @Override
    public String vratiVrednostiUpdate() {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String wherePrimarniKljuc() {
        return " porudzbenicaid = "+ porudzbenica.getPorudzbenicaID();
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InterfaceObjekat> kreirajListu(ResultSet rs) throws Exception {
        List<InterfaceObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new StavkaPorudzbenice(rs.getInt("sp.rb"), rs.getInt("sp.kolicina"), rs.getDouble("sp.ukupnacenasapdvom"), rs.getDouble("sp.ukupnacenabezpdva"), new Artikal(rs.getInt("a.artikalid"), rs.getString("a.nazivartikla"), rs.getDouble("a.cenaartiklasapdvom"), rs.getDouble("a.cenaartiklabezpdva"),JedinicaMere.valueOf(rs.getString("a.jedinicamere")), new Korisnik(rs.getInt("k.korisnikid"), rs.getString("k.ime"), rs.getString("k.prezime"), 
            rs.getString("k.username"), rs.getString("k.password")), new PDVStopa(rs.getInt("ps.pdvstopaid"), rs.getString("ps.naziv"), rs.getInt("ps.iznos"))), null));
        }
        return lista;  
    }

    public Porudzbenica getPorudzbenica() {
        return porudzbenica;
    }

    public void setPorudzbenica(Porudzbenica porudzbenica) {
        this.porudzbenica = porudzbenica;
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
        final StavkaPorudzbenice other = (StavkaPorudzbenice) obj;
        if (!Objects.equals(this.artikal, other.artikal)) {
            return false;
        }
        return true;
    }

}
