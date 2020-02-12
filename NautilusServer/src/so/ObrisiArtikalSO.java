/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.InterfaceObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author User
 */
public class ObrisiArtikalSO extends OpstaSistemskaOperacija{

    public ObrisiArtikalSO() {
        super();
    }

    @Override
    protected void proveriPreduslove(InterfaceObjekat domenskiObjekat) throws Exception {
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(InterfaceObjekat domenskiObjekat) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            getDb().obrisi(domenskiObjekat);
            so.setUspesno(true);
            so.setPoruka("Sistem je obrisao artikal");
        } catch (Exception e) {
             Logger.getLogger(ObrisiArtikalSO.class.getName()).log(Level.SEVERE, null, e);

            throw new Exception("Sisttem nije obrisao artikal");
        }
        return so;
    }
    
}
