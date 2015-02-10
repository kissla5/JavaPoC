package poc;

/**
 *
 * @author k_laszlo
 */
public class C extends A {

    {
        System.out.println("init C");
    }
    
    public C() {
        this(2);
        System.out.println("C");
    }

    public C(int a) {
        super(a);
        System.out.println("C(a)");
    }

}
