/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Porudzbenica implements Serializable, InterfaceObjekat {

    private int porudzbenicaID;
    private Date datumPorudzbenice;
    private double ukupnaCenaSaPdvom;
    private double ukupnaCenaBezPdva;
    private Sto sto;
    private Korisnik korisnik;
    private List<StavkaPorudzbenice> stavkePorudzbenice;

    public Porudzbenica() {
        stavkePorudzbenice = new ArrayList<>();
    }

    public Porudzbenica(int porudzbenicaID, Date datumPorudzbenice, double ukupnaCenaSaPdvom, double ukupnaCenaBezPdva, Sto sto, Korisnik korisnik, List<StavkaPorudzbenice> stavkePorudzbenice) {
        this.porudzbenicaID = porudzbenicaID;
        this.datumPorudzbenice = datumPorudzbenice;
        this.ukupnaCenaSaPdvom = ukupnaCenaSaPdvom;
        this.ukupnaCenaBezPdva = ukupnaCenaBezPdva;
        this.sto = sto;
        this.korisnik = korisnik;
        this.stavkePorudzbenice = stavkePorudzbenice;
    }

    public int getPorudzbenicaID() {
        return porudzbenicaID;
    }

    public void setPorudzbenicaID(int porudzbenicaID) {
        this.porudzbenicaID = porudzbenicaID;
    }

    public Date getDatumPorudzbenice() {
        return datumPorudzbenice;
    }

    public void setDatumPorudzbenice(Date datumPorudzbenice) {
        this.datumPorudzbenice = datumPorudzbenice;
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

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<StavkaPorudzbenice> getStavkePorudzbenice() {
        return stavkePorudzbenice;
    }

    public void setStavkePorudzbenice(List<StavkaPorudzbenice> stavkePorudzbenice) {
        this.stavkePorudzbenice = stavkePorudzbenice;
    }

    @Override
    public String nazivTabele() {
        return " porudzbenica ";
    }

    @Override
    public String joinUslov() {
        return "p JOIN korisnik k ON (p.KorisnikID=k.KorisnikID) JOIN sto s ON (p.StoID=s.StoID)";
    }

    @Override
    public String vratiWhereZaSelect() {
         if(datumPorudzbenice==null)
            return "";
        //if(!sdf.format(datumIzrade).equals("")){
        
        return " WHERE p.DatumPorudzbenice = '"+new java.sql.Date(datumPorudzbenice.getTime())+"'";
    }

    @Override
    public String sortiranje() {
        return " ORDER BY p.DatumPorudzbenice ASC"; 
    }

    @Override
    public String naziviKolona() {
        return "DatumPorudzbenice, UkupnaCenaSaPdvom, UkupnaCenaBezPdva, StoID, KorisnikID";
    }

    @Override
    public String vrednostiKolona() {
        return "'"+new java.sql.Date(datumPorudzbenice.getTime())+"' , '"+ukupnaCenaSaPdvom+"', '"+ukupnaCenaBezPdva+"', '"+sto.getStoID()+"', '"+korisnik.getKorisnikID()+"'";
    }

    @Override
    public String vratiVrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String wherePrimarniKljuc() {
        return " PorudzbenicaID = "+porudzbenicaID;
    }

    @Override
    public String maxKljuc() {
        return " PorudzbenicaID ";
    }

    @Override
    public List<InterfaceObjekat> kreirajListu(ResultSet rs) throws Exception {
        List<InterfaceObjekat> lista = new ArrayList<>();
        while (rs.next()) { 
            
            lista.add(new Porudzbenica(rs.getInt("p.PorudzbenicaID"), new Date(rs.getDate("p.DatumPorudzbenice").getTime()), rs.getDouble("p.UkupnaCenaSaPdvom"), rs.getDouble("p.UkupnaCenaBezPdva"), new Sto(rs.getInt("s.StoID"), rs.getString("s.PozicijaStola"), rs.getInt("BrojLjudi"), rs.getByte("Status")), new Korisnik(rs.getInt("k.KorisnikID"), rs.getString("k.Ime"), rs.getString("k.Prezime"), rs.getString("k.Username"), rs.getString("k.Password")), null));
        }
        return lista;  
    }

}
