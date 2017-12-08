/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffimplement;

import java.io.*;

/**
 *
 * @author gyani
 */
public class DiffImplement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IListMethods i;
        
        i = new MyArray();
        i.add(1);
        i.remove(1);
        i.count();
        
        i = new MyLL();
        i.add(1);
        i.remove(1);
        i.count();
    }
}
