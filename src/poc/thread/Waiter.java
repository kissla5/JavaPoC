package poc.thread;

 // The Waiter runs as an independent thread
// It interacts with the CoffeeMachine to wait for a coffee
// and deliver the coffee once ready and request the coffee machine
// for the next one, and this activity keeps going on forever . . .
public class Waiter extends Thread {

    public void getCoffee() {
        synchronized (CoffeeMachine.lock) {
            if (CoffeeMachine.coffeeMade == null) {
                try {
// wait till the CoffeeMachine says (notifies) that
// coffee is ready
                    System.out.println("Waiter: Will get orders till coffee machine notifies me ");
//                    sleep(5000);
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException ie) {
// its okay to ignore this exception
// since we're not using thread interrupt mechanism
                    ie.printStackTrace();
                }
            }
            System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
            try {
                CoffeeMachine.lock.wait(16000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            CoffeeMachine.coffeeMade = null;
// ask (notify) the coffee machine to prepare the next coffee
            CoffeeMachine.lock.notifyAll();
            System.out.println("Waiter: Notifying coffee machine to make another one");
        }
    }

    @Override
    public void run() {
// keep going till the user presses ctrl-C and terminates the program
        while (true) {
            getCoffee();
        }
    }
}
