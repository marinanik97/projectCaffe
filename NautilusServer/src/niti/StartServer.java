/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forma.FServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class StartServer extends Thread{
    FServer sf;

    public StartServer(FServer sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            StopServer zs = new StopServer(this, ss);
            zs.start();
            int brojac = 1;
            while (!isInterrupted()) {                
                Socket s = ss.accept();
                System.out.println("Klijent se povezao");
                String imeKlijenta = "Klijent "+brojac;
                brojac++;
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s, imeKlijenta);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
