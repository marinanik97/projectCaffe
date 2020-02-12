/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Artikal;
import domen.InterfaceObjekat;
import domen.Porudzbenica;
import domen.StavkaPorudzbenice;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerskiOdgovor;

/**
 *
 * @author User
 */
public class IzmenaArtiklaSO extends OpstaSistemskaOperacija {

    public IzmenaArtiklaSO() {

    }

    @Override
    protected void proveriPreduslove(InterfaceObjekat domenskiObjekat) throws Exception {
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(InterfaceObjekat domenskiObjekat) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();

        try {
            getDb().izmeni(domenskiObjekat);
            so.setUspesno(true);
            so.setPoruka("Sistem je izmenio artikal");

        } catch (Exception e) {
            Logger.getLogger(IzmenaArtiklaSO.class.getName()).log(Level.SEVERE, null, e);

            throw new Exception("Sistem nije izmenio artikal");

        }

        return so;
    }

}
