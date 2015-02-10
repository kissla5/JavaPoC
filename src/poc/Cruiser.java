/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

/**
 *
 * @author kissla
 */
public class Cruiser implements Runnable {
    private int a = 0;
    
    public void run() {
        System.out.print("go");
    }
    
    public static void testCruiser(String arg[]) {
        Thread t = new Thread(new Cruiser());
        t.run();
        t.run();
        t.start();
    }
    
    public void testLittleCruiser() {
        Runnable r = new LittleCruiser();
        new Thread(r).start();
        new Thread(r).start();
    }
    
    public class LittleCruiser implements Runnable {
        public void run() {
            int current = 0;
            for (int i = 0; i < 4; i++) {
                current = a;
                System.out.print(current + ", ");
                a = current + 2;
            }
        }
    }
}
