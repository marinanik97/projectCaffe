/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitabela;

import domen.InterfaceObjekat;
import domen.StavkaPorudzbenice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maja
 */
public class ModelTabeleStavki extends AbstractTableModel{
    
    List<InterfaceObjekat> listaStavki;
    String[] naziviKolona = {"Rb", "Artikal", "Kolicina", "Cena (sa PDV-om)" , "Cena (bez PDV-a)", "Ukupno (sa PDV-om)", "Ukupno(bez PDV-a)"};

    public ModelTabeleStavki() {
        listaStavki = new ArrayList<>();
    }

    public void setListaStavki(List<InterfaceObjekat> listaStavki) {
        this.listaStavki = listaStavki;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPorudzbenice sp = (StavkaPorudzbenice) listaStavki.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return sp.getRb();
            case 1: return sp.getArtikal();
            case 2: return sp.getKolicina();
            case 3: return sp.getArtikal().getCenaArtiklaSaPdvom();
            case 4: return sp.getArtikal().getCenaArtiklaBezPdva();
            case 5: return sp.getArtikal().getCenaArtiklaSaPdvom() * sp.getKolicina();
            case 6: return sp.getArtikal().getCenaArtiklaBezPdva()* sp.getKolicina();
            
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void dodajStavku(StavkaPorudzbenice sp) {
        listaStavki.add((InterfaceObjekat) sp);
        srediRedneBrojeve();
        fireTableDataChanged();
    }

    public ArrayList getListaStavki() {
        return (ArrayList) listaStavki;
    }

    private void srediRedneBrojeve() {
        ArrayList<StavkaPorudzbenice> lista = (ArrayList)listaStavki;
        int brojac = 1;
        for (StavkaPorudzbenice st : lista) {
            st.setRb(brojac++);
        }
    }

    public void obrisiStavku(int red) {
        listaStavki.remove(red);
        srediRedneBrojeve();
        fireTableDataChanged();
    }


    public void osveziKolicinu(StavkaPorudzbenice stavkaP, int kolicina) {
        int kol = stavkaP.getKolicina();
        stavkaP.setKolicina(kol+kolicina);
        fireTableDataChanged();
    }

  
    
    
    
    
}
