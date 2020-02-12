/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitabela;

import domen.InterfaceObjekat;
import domen.Artikal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabeleArtikli extends AbstractTableModel{

    List<InterfaceObjekat> listaArtikala;
    String[] naziviKolona = {"Naziv artikla", "Cena artikla sa pdv-om", "Cena artikla bez pdv-a", "Jedinica mere", "Kreirano od", "Racunato po"};
    
    public ModelTabeleArtikli() {
        listaArtikala = new ArrayList<>() ;
    }

    @Override
    public int getRowCount() {
        return listaArtikala.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Artikal a = (Artikal) listaArtikala.get(rowIndex);
        switch(columnIndex){
            case 0: return a.getNazivArtikla();
            case 1: return a.getCenaArtiklaSaPdvom();
            case 2: return a.getCenaArtiklaBezPdva();
            case 3: return a.getJedinicaMere();
            case 4: return a.getKorisnik();
            case 5: return a.getPdvStopa();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void setLista(List<InterfaceObjekat> listaArtikala) {
        this.listaArtikala = listaArtikala;
        fireTableDataChanged();
    }

    public Artikal vratiSelektovaniArtikal(int red) {
        return (Artikal) listaArtikala.get(red);
    }

    public void refresh() {
        fireTableDataChanged();
    }

    
    
    
    
}
