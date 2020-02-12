/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class ValidatorForme {
    private static ValidatorForme instanca;
    String poruka="";

    private ValidatorForme() {
    }

    public static ValidatorForme getInstanca() {
        if(instanca==null)
            instanca = new ValidatorForme();
        return instanca;
    }
    
    public boolean validacijaPolja(JTextField... Polja){
        boolean validno = true;
        int brojacLosih = 0;
        for (JTextField p : Polja) {
            if("".equals(p.getText())){
                p.setBorder(BorderFactory.createLineBorder(Color.RED, 3, true));
                brojacLosih++;
                validno = false;
            }
        }
        
        if(!validno)
         poruka =   brojacLosih==1 ? "Dato polje ne sme biti prazno": "Data polja ne smeju biti prazna";
        
        return validno;       
    }

    public String getPoruka() {
        return poruka;
    }
    
    
    
    
}
