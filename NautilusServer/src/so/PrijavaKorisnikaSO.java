/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.InterfaceObjekat;
import domen.Korisnik;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Maja
 */
public class PrijavaKorisnikaSO extends OpstaSistemskaOperacija {

    public PrijavaKorisnikaSO() {
        super();
    }

    @Override
    protected void proveriPreduslove(InterfaceObjekat domenskiObjekat) throws Exception {

    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(InterfaceObjekat domenskiObjekat) throws Exception {
        List<InterfaceObjekat> listaKorisnika;
        try {
            listaKorisnika = domenskiObjekat.kreirajListu(getDb().vrati(domenskiObjekat));
        } catch (Exception e) {
            Logger.getLogger(PrijavaKorisnikaSO.class.getName()).log(Level.SEVERE, null, e);

            throw new Exception("Neuspesno prijavljivanje na sistem");
        }
        if (listaKorisnika.isEmpty()) {
            throw new Exception("Neuspesno prijavljivanje na sistem");
        }
        ServerskiOdgovor so = new ServerskiOdgovor();
        so.setUspesno(true);
        so.setPoruka("Uspesno ste se prijavili na sistem");
        so.setOdgovor(listaKorisnika.get(0));
        return so;

    }

}
