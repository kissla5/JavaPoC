/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author k_laszlo
 */
class MySingleton {

    private static MySingleton instance = new MySingleton();
    private Integer i = new Integer(0);

    private MySingleton() {
    }

    static MySingleton getInstance() {
        return instance;
    }

    String add() {
        i += 1;
        try {
            Thread.sleep(Math.round(Math.random() * 100));
        } catch (InterruptedException ex) {
            System.out.println("Interruption!" + ex);
        }

        return i.toString();
    }

}
