/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Artikal;
import domen.Korisnik;
import domen.PDVStopa;
import domen.Porudzbenica;
import domen.StavkaPorudzbenice;
import domen.Sto;
import konstante.Konstante;
import povezivanje.Komunikacija;
import transfer.KlijentskiZahtev;
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

    public ServerskiOdgovor prijaviNaSistem(Korisnik k) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.ULOGUJ_KORISNIKA, k);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor VratiPdvStope() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_PDVSTOPE, new PDVStopa());
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor vratiArtikle() {
        Artikal a = new Artikal();
        a.setNazivArtikla("");
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_ARTIKAL, a);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor sacuvajArtikal(Artikal a) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.UNOS_ARTIKLA, a);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor pronadjiArtikle(Artikal a) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.PRETRAGA_ARTIKALA, a);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiArtikal(Artikal a) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.BRISANJE_ARTIKLA, a);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniArtikal(Artikal novi) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.IZMENA_ARTIKLA, novi);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor vratiStolove() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_STOLOVE, new Sto());
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor sacuvajPorudzbenicu(Porudzbenica p) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.UNOS_PORUDZBENICE, p);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor pretraziPorudzbenice(Porudzbenica p) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.PRETRAGA_PORUDZBENICE, p);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiPorudzbenicu(Porudzbenica p) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.BRISANJE_PORUDZBENICE, p);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniSto(Sto sto) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.IZMENA_STOLA, sto);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

//    public ServerskiOdgovor obrisiStavke(StavkaPorudzbenice sp) {
//        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.BRISANJE_STAVKI, sp);
//        Komunikacija.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
//        return so;
//    }


}
