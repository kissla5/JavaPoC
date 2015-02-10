/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

/**
 *
 * @author k_laszlo
 */
public class GenericTestChild extends GenericTest<MyClass> {

    public GenericTestChild() {
        super(MyClass.class);
    }
}
