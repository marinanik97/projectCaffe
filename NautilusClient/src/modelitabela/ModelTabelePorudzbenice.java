/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitabela;

import domen.InterfaceObjekat;
import domen.Porudzbenica;
import domen.StavkaPorudzbenice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maja
 */
public class ModelTabelePorudzbenice extends AbstractTableModel{
    
    List<InterfaceObjekat> listaPorudzbenica;
    String[] naziviKolona = {"Pozicija stola", "Datum", "Artikli", "Ukupna cena (sa PDV-om)", "Ukupna cena (bez PDV-a)"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    
    public ModelTabelePorudzbenice() {
        listaPorudzbenica = new ArrayList<>();
    }
    
    

    @Override
    public int getRowCount() {
        return listaPorudzbenica.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Porudzbenica p = (Porudzbenica) listaPorudzbenica.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getSto();
            case 1: return sdf.format(p.getDatumPorudzbenice());
            case 2: String proizvodi = "";
                    for (StavkaPorudzbenice sp : p.getStavkePorudzbenice()) {
                        proizvodi+=sp.getArtikal()+", ";
                    }
                    return proizvodi;
               
            case 3: return p.getUkupnaCenaSaPdvom()+"";
            case 4: return p.getUkupnaCenaBezPdva()+"";
            default: return "";
        }
     }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public Porudzbenica dajPorudzbenicu(int red) {
        return (Porudzbenica) listaPorudzbenica.get(red);
    }

    public void setLista(List<InterfaceObjekat> listaPorudzbenica) {
        this.listaPorudzbenica = listaPorudzbenica;
    }

    public void refresh() {
        fireTableDataChanged();
    }
    
    
    }
    
    

