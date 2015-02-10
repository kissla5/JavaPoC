/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

import java.lang.reflect.ParameterizedType;

/**
 *
 * @author k_laszlo
 */
public class GenericTest<T extends MyClass> implements IGenericTest<T> {

    Class<T> clazz;

    public GenericTest() {
        System.out.println("Type: " + (Class)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public GenericTest(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Test.
     */
    @Override
    public synchronized void test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
