/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

import java.util.List;

/**
 *
 * @author k_laszlo
 */
public class MyClass {

    {
        setNumber(12);
        System.out.println("Static init");
    }

    private Number number;
    private List<Number> numbers;

    public MyClass() {
        System.out.println("Init");
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyClass other = (MyClass) obj;
        if (this.number != other.number && (this.number == null || !this.number.equals(other.number))) {
            return false;
        }
        if (this.numbers != other.numbers && (this.numbers == null || !this.numbers.equals(other.numbers))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.number != null ? this.number.hashCode() : 0);
        hash = 83 * hash + (this.numbers != null ? this.numbers.hashCode() : 0);
        return hash;
    }


}
