/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.InterfaceObjekat;
import so.IzmenaArtiklaSO;
import so.IzmenaStolaSO;
import so.ObrisiArtikalSO;
import so.ObrisiPorudzbenicuSO;
import so.PrijavaKorisnikaSO;
import so.PronadjiArtikleSO;
import so.PronadjiPorudzbeniceSO;
import so.SacuvajArtikalSO;
import so.SacuvajPorudzbenicuSO;
import so.VratiArtikleSO;
import so.VratiPdvStopeSO;
import so.VratiStoloveSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author User
 */
public class Kontroler {

    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ServerskiOdgovor ulogujKorisnika(InterfaceObjekat domenskiObjekat) {
        return new PrijavaKorisnikaSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor vratiPdvStope(InterfaceObjekat domenskiObjekat) {
        return new VratiPdvStopeSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor vratiArtikle(InterfaceObjekat domenskiObjekat) {
        return new VratiArtikleSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor sacuvajArtikal(InterfaceObjekat domenskiObjekat) {
        return new SacuvajArtikalSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor pronadjiArtikle(InterfaceObjekat domenskiObjekat) {
        return new PronadjiArtikleSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor obrisiArtikal(InterfaceObjekat domenskiObjekat) {
        return new ObrisiArtikalSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor izmeniArtikal(InterfaceObjekat domenskiObjekat) {
        return new IzmenaArtiklaSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor vratiStolove(InterfaceObjekat domenskiObjekat) {
        return new VratiStoloveSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor sacuvajPorudzbenicu(InterfaceObjekat domenskiObjekat) {
        return new SacuvajPorudzbenicuSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor pronadjiPorudzbenice(InterfaceObjekat domenskiObjekat) {
        return new PronadjiPorudzbeniceSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor brisanjePorudzbenice(InterfaceObjekat domenskiObjekat) {
        return new ObrisiPorudzbenicuSO().izvrsiTransakciju(domenskiObjekat);
    }

    public ServerskiOdgovor izmeniSto(InterfaceObjekat domenskiObjekat) {
        return new IzmenaStolaSO().izvrsiTransakciju(domenskiObjekat);
    }


}
