/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.InterfaceObjekat;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class KlijentskiZahtev implements Serializable{
    private String operacija;
    private InterfaceObjekat parametar;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(String operacija, InterfaceObjekat parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public InterfaceObjekat getParametar() {
        return parametar;
    }

    public void setParametar(InterfaceObjekat parametar) {
        this.parametar = parametar;
    }

    public String getOperacija() {
        return operacija;
    }

    public void setOperacija(String operacija) {
        this.operacija = operacija;
    }
    
    
}
