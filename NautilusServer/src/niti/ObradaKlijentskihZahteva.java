/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.InterfaceObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author User
 */
public class ObradaKlijentskihZahteva extends Thread{
    Socket s;
    String imeKlijenta;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket s, String imeKlijenta) {
        this.s = s;
        this.imeKlijenta = imeKlijenta;
    }

    @Override
    public void run() {
        while (!kraj) {            
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            System.out.println("Operacija: "+kz.getOperacija());
            InterfaceObjekat domenskiObjekat = kz.getParametar();
            switch(kz.getOperacija()){
                case Konstante.ULOGUJ_KORISNIKA:
                    so = Kontroler.getInstanca().ulogujKorisnika(domenskiObjekat);
                    break;
                case Konstante.VRATI_PDVSTOPE:
                    so = Kontroler.getInstanca().vratiPdvStope(domenskiObjekat);
                    break;
                case Konstante.VRATI_ARTIKAL:
                    so = Kontroler.getInstanca().vratiArtikle(domenskiObjekat);
                    break;
                case Konstante.UNOS_ARTIKLA:
                    so = Kontroler.getInstanca().sacuvajArtikal(domenskiObjekat);
                    break;
                case Konstante.PRETRAGA_ARTIKALA:
                    so = Kontroler.getInstanca().pronadjiArtikle(domenskiObjekat);
                    break;
                case Konstante.BRISANJE_ARTIKLA:
                    so = Kontroler.getInstanca().obrisiArtikal(domenskiObjekat);
                    break;
                case Konstante.IZMENA_ARTIKLA:
                    so = Kontroler.getInstanca().izmeniArtikal(domenskiObjekat);
                    break;
                case Konstante.VRATI_STOLOVE:
                    so = Kontroler.getInstanca().vratiStolove(domenskiObjekat);
                    break;
                case Konstante.UNOS_PORUDZBENICE:
                    so = Kontroler.getInstanca().sacuvajPorudzbenicu(domenskiObjekat);
                    break;
                 case Konstante.PRETRAGA_PORUDZBENICE:
                    so = Kontroler.getInstanca().pronadjiPorudzbenice(domenskiObjekat);
                    break;
                case Konstante.BRISANJE_PORUDZBENICE:
                    so = Kontroler.getInstanca().brisanjePorudzbenice(domenskiObjekat);
                    break;
                case Konstante.IZMENA_STOLA:
                    so = Kontroler.getInstanca().izmeniSto(domenskiObjekat);
                    break;
//                case Konstante.BRISANJE_STAVKI:
//                    so = Kontroler.getInstanca().brisanjeStavki(domenskiObjekat);
//                    break;
                                  
            }
            
            posaljiOdgovor(so);
        }
    }

    public KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kz;
    }

    public void posaljiOdgovor(ServerskiOdgovor so) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
