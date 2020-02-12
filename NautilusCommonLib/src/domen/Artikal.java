/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Artikal implements Serializable, InterfaceObjekat{
    private int artikalid;
    private String nazivArtikla;
    private double cenaArtiklaSaPdvom;
    private double cenaArtiklaBezPdva;
    private JedinicaMere jedinicaMere;
    private Korisnik korisnik;
    private PDVStopa pdvStopa;

    public Artikal() {
    }

    public Artikal(int artikalid, String nazivArtikla, double cenaArtiklaSaPdvom, double cenaArtiklaBezPdva, JedinicaMere jedinicaMere, Korisnik korisnik, PDVStopa pdvStopa) {
        this.artikalid = artikalid;
        this.nazivArtikla = nazivArtikla;
        this.cenaArtiklaSaPdvom = cenaArtiklaSaPdvom;
        this.cenaArtiklaBezPdva = cenaArtiklaBezPdva;
        this.jedinicaMere = jedinicaMere;
        this.korisnik = korisnik;
        this.pdvStopa = pdvStopa;
    }
    
   

    public int getArtikalid() {
        return artikalid;
    }

    public void setArtikalid(int artikalid) {
        this.artikalid = artikalid;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public double getCenaArtiklaSaPdvom() {
        return cenaArtiklaSaPdvom;
    }

    public void setCenaArtiklaSaPdvom(double cenaArtiklaSaPdvom) {
        this.cenaArtiklaSaPdvom = cenaArtiklaSaPdvom;
    }

    public double getCenaArtiklaBezPdva() {
        return cenaArtiklaBezPdva;
    }

    public void setCenaArtiklaBezPdva(double cenaArtiklaBezPdva) {
        this.cenaArtiklaBezPdva = cenaArtiklaBezPdva;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public PDVStopa getPdvStopa() {
        return pdvStopa;
    }

    public void setPdvStopa(PDVStopa pdvStopa) {
        this.pdvStopa = pdvStopa;
    }

    @Override
    public String nazivTabele() {
        return " artikal ";
    }

    @Override
    public String joinUslov() {
        return "a JOIN korisnik k ON (a.KorisnikID=k.KorisnikID) JOIN pdvstopa ps ON (a.PdvStopaID=ps.PdvStopaID)";
    }

    @Override
    public String vratiWhereZaSelect() {
         if(!nazivArtikla.equals("")){
            return " WHERE a.NazivArtikla LIKE '%"+nazivArtikla+"%'";
        }
        return "";
    }

    @Override
    public String sortiranje() {
        return " ORDER BY a.CenaArtiklaSaPdvom ASC";
    }

    @Override
    public String naziviKolona() {
        return "NazivArtikla, CenaArtiklaSaPdvom, CenaArtiklaBezPdva, JedinicaMere, KorisnikID, PdvStopaID";
    }

    @Override
    public String vrednostiKolona() {
        return "'"+nazivArtikla+"',"+cenaArtiklaSaPdvom+", '"+cenaArtiklaBezPdva+"', '"+jedinicaMere+"', '"+getKorisnik().getKorisnikID()+"', '"+getPdvStopa().getPdvID()+"'";
    }

    @Override
    public String vratiVrednostiUpdate() {
        return " NazivArtikla = '"+nazivArtikla+"', CenaArtiklaSaPdvom = '"+cenaArtiklaSaPdvom+"', CenaArtiklaBezPdva = '"+cenaArtiklaBezPdva+"', JedinicaMere = '"+jedinicaMere+"', KorisnikID = '"+getKorisnik().getKorisnikID()+"', PdvStopaID = '"+getPdvStopa().getPdvID()+"'";
    }

    @Override
    public String wherePrimarniKljuc() {
        return " artikalid = '" + artikalid+"'";
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InterfaceObjekat> kreirajListu(ResultSet rs) throws Exception {
        List<InterfaceObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new Artikal(rs.getInt("ArtikalID"), rs.getString("NazivArtikla"), rs.getDouble("CenaArtiklaSaPdvom"), rs.getDouble("CenaArtiklaBezPdva"), JedinicaMere.valueOf(rs.getString("JedinicaMere")), new Korisnik(rs.getInt("KorisnikID"), rs.getString("Ime"),rs.getString("Prezime")
            ,rs.getString("Username"),rs.getString("Password")),new PDVStopa(rs.getInt("PdvStopaID"), rs.getString("Naziv"), rs.getInt("Iznos"))));
        }
        return lista;
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
        final Artikal other = (Artikal) obj;
        if (Double.doubleToLongBits(this.cenaArtiklaSaPdvom) != Double.doubleToLongBits(other.cenaArtiklaSaPdvom)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cenaArtiklaBezPdva) != Double.doubleToLongBits(other.cenaArtiklaBezPdva)) {
            return false;
        }
        if (!Objects.equals(this.nazivArtikla, other.nazivArtikla)) {
            return false;
        }
        if (!Objects.equals(this.jedinicaMere, other.jedinicaMere)) {
            return false;
        }
        if (!Objects.equals(this.korisnik, other.korisnik)) {
            return false;
        }
        if (!Objects.equals(this.pdvStopa, other.pdvStopa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivArtikla;
    }
    
}
