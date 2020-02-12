/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.InterfaceObjekat;
import domen.Porudzbenica;
import domen.StavkaPorudzbenice;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author User
 */
public class PronadjiPorudzbeniceSO extends OpstaSistemskaOperacija{
     public PronadjiPorudzbeniceSO() {
        super();
    }

    @Override
    protected void proveriPreduslove(InterfaceObjekat domenskiObjekat) throws Exception {
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(InterfaceObjekat domenskiObjekat) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        List<InterfaceObjekat> listaPor = new ArrayList<>();
        try {
          List<InterfaceObjekat> lista = domenskiObjekat.kreirajListu(getDb().vrati(domenskiObjekat));
            for (InterfaceObjekat iObjekat : lista) {
                Porudzbenica p = (Porudzbenica) iObjekat;
                StavkaPorudzbenice sp = new StavkaPorudzbenice();
                sp.setPorudzbenica(p);
                List<InterfaceObjekat> listaS = sp.kreirajListu(getDb().vrati(sp));
                ArrayList<StavkaPorudzbenice> listaSt = new ArrayList<>();
                for (InterfaceObjekat stavkaporudzbenice : listaS) {
                    listaSt.add((StavkaPorudzbenice) stavkaporudzbenice);
                }
                p.setStavkePorudzbenice(listaSt);
                listaPor.add(p);
            }
          so.setUspesno(true);
          so.setOdgovor(listaPor);
          so.setPoruka("Uspesno pronadjena lista porudzbenica");            
        } catch (Exception e) {
            Logger.getLogger(PronadjiPorudzbeniceSO.class.getName()).log(Level.SEVERE, null, e);

            throw new Exception("Nije pronadjena lista porudzbenica");
        }
        return so;
    }
}
