/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Artikal;
import domen.InterfaceObjekat;
import domen.JedinicaMere;
import domen.Korisnik;
import domen.PDVStopa;
import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modelitabela.ModelTabeleArtikli;
import transfer.ServerskiOdgovor;
import validator.ValidatorForme;

/**
 *
 * @author User
 */
public class FKreirajArtikal extends javax.swing.JDialog {
    Korisnik k;
    /**
     * Creates new form FKreirajArtikal
     */
    public FKreirajArtikal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popuniJedinicuMere();
        popuniPdvStope();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcombojedinica = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcombopdv = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jlabkorisnik = new javax.swing.JLabel();
        jtxtnaziv = new javax.swing.JTextField();
        jtxtcena = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiranje artikla");

        jLabel1.setText("Naziv artikla: ");

        jLabel3.setText("Cena artikla bez PDV-om:");

        jLabel4.setText("Jedinica mere: ");

        jLabel5.setText("PDV Stopa:");

        jLabel6.setText("Korisnik:");

        jlabkorisnik.setText("jlabkorisnik");

        jButton1.setText("Sacuvaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtnaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabkorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcombopdv, 0, 323, Short.MAX_VALUE)
                            .addComponent(jtxtcena)
                            .addComponent(jcombojedinica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlabkorisnik))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtnaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcombojedinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcombopdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         boolean val=ValidatorForme.getInstanca().validacijaPolja(jtxtnaziv, jtxtcena);
        if(!val){
            JOptionPane.showMessageDialog(this, ValidatorForme.getInstanca().getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }   
        double cenabez = 0.0;
        String naziv = jtxtnaziv.getText();
        val=true;
        for (char c : naziv.toCharArray()) {
            if(isDigit(c))
                val=false;
        }
        if(val==false){
            JOptionPane.showMessageDialog(this, "Naziv ne sme sadrzati cifre","Greska", JOptionPane.ERROR_MESSAGE);
            return; 
        }          
        try {
          cenabez = Double.parseDouble(jtxtcena.getText()); 
          if(cenabez==0)
              return;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "Cena mora biti broj", "Greska", JOptionPane.ERROR_MESSAGE);
          return;
        }
        String jmS = (String) jcombojedinica.getSelectedItem();
        JedinicaMere jm = JedinicaMere.valueOf(jmS) ;
        PDVStopa pdv = (PDVStopa) jcombopdv.getSelectedItem();
        double cenasa=0;
        double iznos = pdv.getIznos();
         cenasa =  (double)cenabez * (1 + (double)iznos/100);
        
        Artikal a = new Artikal(-1, naziv, cenasa, cenabez, jm, k, pdv);
        
        ServerskiOdgovor so = Kontroler.getInstanca().vratiArtikle();

        if(so.isUspesno()){
            List<InterfaceObjekat> lista = (List<InterfaceObjekat>) so.getOdgovor();
            ArrayList<Artikal> listaPostojecih = new ArrayList<>();
            for (InterfaceObjekat io : lista) {
                listaPostojecih.add((Artikal) io);
            }
            
            if(listaPostojecih.contains(a)){
                JOptionPane.showMessageDialog(this, "Taj artikal vec postoji u bazi", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }               
        }
        else{
            JOptionPane.showMessageDialog(this, so.getPoruka(),"Greska", JOptionPane.ERROR_MESSAGE);
        }        
        ServerskiOdgovor so1 = Kontroler.getInstanca().sacuvajArtikal(a);
        JOptionPane.showMessageDialog(this, so1.getPoruka()); 
        ocistiFormu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FGlavniMeni fg = (FGlavniMeni) getParent();
        fg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FKreirajArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FKreirajArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FKreirajArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FKreirajArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FKreirajArtikal dialog = new FKreirajArtikal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jcombojedinica;
    private javax.swing.JComboBox<domen.PDVStopa> jcombopdv;
    private javax.swing.JLabel jlabkorisnik;
    private javax.swing.JTextField jtxtcena;
    private javax.swing.JTextField jtxtnaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniJedinicuMere() {
        jcombojedinica.removeAllItems();
        List<String> lista = new ArrayList<>();
        lista.add("kom");
        lista.add("ml");
        for (String string : lista) {
            jcombojedinica.addItem(string);
        }
    }

    private void popuniPdvStope() {
        ServerskiOdgovor so = Kontroler.getInstanca().VratiPdvStope();

        if(so.isUspesno()){
          List<InterfaceObjekat> lista = (List<InterfaceObjekat>) so.getOdgovor();
            jcombopdv.removeAllItems();
            for (InterfaceObjekat objekat : lista) {
                jcombopdv.addItem((PDVStopa) objekat);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, so.getPoruka(),"Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    void setKorisnik(Korisnik k) {
        this.k = k;
        jlabkorisnik.setText(k.getIme() + " " + k.getPrezime());
    }
    
    private void ocistiFormu() {
        jtxtcena.setText("");
        jtxtnaziv.setText("");
    }

}
