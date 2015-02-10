/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.thread;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kissla
 */
public class Duke extends Thread {
    Exchanger<String> msg;

    public Duke(Exchanger<String> msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String exchange = msg.exchange("Hey, which coffee have you made?");
                System.out.println("Coffee machines said: " + exchange);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Duke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
