/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class ServerskiOdgovor implements Serializable{
    private String operacija;
    private String poruka;
    private Object odgovor;
    private boolean uspesno;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String operacija, String poruka, Object odgovor, boolean uspesno) {
        this.operacija = operacija;
        this.poruka = poruka;
        this.odgovor = odgovor;
        this.uspesno = uspesno;
    }

    public String getOperacija() {
        return operacija;
    }

    public void setOperacija(String operacija) {
        this.operacija = operacija;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
}
