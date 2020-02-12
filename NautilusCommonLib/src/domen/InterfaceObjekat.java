/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Maja
 */
public interface InterfaceObjekat extends Serializable{

    public String nazivTabele();

    public String joinUslov();

    public String vratiWhereZaSelect();

    public String sortiranje();

    public String naziviKolona();

    public String vrednostiKolona();

    public String vratiVrednostiUpdate();

    public String wherePrimarniKljuc();

    public String maxKljuc();

    List<InterfaceObjekat> kreirajListu(ResultSet rs) throws Exception;
}
