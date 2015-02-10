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
public class SupressedResource implements AutoCloseable{

    public void throwSomething() {
        throw new RuntimeException("Something");
    }
    
    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
