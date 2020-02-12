/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import forme.FLogin;
import forme.FGlavniMeni;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class ThreadClock extends Thread {

    FLogin forma;
    FGlavniMeni fm;

    public ThreadClock(FLogin forma) {
        this.forma = forma;
    }

    public ThreadClock(FGlavniMeni fm) {
        this.fm = fm;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (forma != null) {
                    forma.showDate();
                    sleep(1000);
                } else {
                    fm.showDate();
                    sleep(1000);
                }

            }
        } catch (InterruptedException ex) {
            System.out.println("Greska, Thread Clock klasa. " + ex.getMessage());
        }
    }
}
