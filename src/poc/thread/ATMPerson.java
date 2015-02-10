/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.thread;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
//import poc.ABC;

/**
 *
 * @author kissla
 */
public class ATMPerson extends Thread {
    Semaphore machines;
    String name;

    public ATMPerson(Semaphore machines, String name) {
        this.machines = machines;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        System.out.println("I'm waiting: " + name);
        try {
            machines.acquire();
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ATMPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("I'm at the machine: " + name);
        machines.release();
    }
    
    
}
