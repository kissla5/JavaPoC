package poc;

/**
 *
 * @author k_laszlo
 */
public class A {
    int a;

    {
        System.out.println("init A");
    }
    public A(int a) {
        System.out.println("A(a)");
        this.a = a;
    }

}
