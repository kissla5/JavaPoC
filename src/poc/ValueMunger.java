/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poc;

import java.lang.*;
import java.lang.reflect.Field;

class ValueMunger extends Thread {
    public void run() {
        while(true) {
            munge();
            try { sleep(1000); } catch (Throwable t) { }
        }
    }

    public void munge() {
        try {
            Field field = Integer.class.getDeclaredField( "value" );
            field.setAccessible( true );
            for(int i = -127; i<=128; i++)
            field.setInt(
                Integer.valueOf(i),
                // either the same (90%), +1 (10%), or 42 (1%)
                Math.random() < 0.9 ? i : Math.random() < 0.1 ? 42 : i+1  );
        } catch (Throwable t) { ; }
    }

}
