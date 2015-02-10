/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

/**
 *
 * @author k_laszlo
 */
public class HashClass {
    private String string;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HashClass other = (HashClass) obj;
        if ((this.string == null) ? (other.string != null) : !this.string.equals(other.string)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.string != null ? this.string.hashCode() : 0);
        return hash;
    }

    
}
