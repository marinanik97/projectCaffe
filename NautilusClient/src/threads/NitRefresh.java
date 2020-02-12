/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import forme.FRadSaArtiklima;
import forme.FRadSaPorudzbenicama;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class NitRefresh extends Thread{
    FRadSaArtiklima fra;
    boolean status;

    public NitRefresh(FRadSaArtiklima fra) {
        this.fra = fra;
        status = false;
    }

    @Override
    public void run() {
        while(true){
        try {
          if(status == false){
              fra.sreditabelu();
          }
          else{
              fra.srediTabelu2();
          }
            sleep(10000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(NitRefresh.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public void setStatus(){
        status=true;
    }
    
}
