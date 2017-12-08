/*
 * Singleton Class is a Class in which
 * only one object gets created from it.
 */
package singleton;
import java.io.*;

/**
 *
 * @author gyani
 */
public class Sample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Singleton s1;
        //s1 = new Singleton(); would give an error
        s1 = Singleton.Create();
        s1.secret=7;
        
        Singleton s2;
        s2 = Singleton.Create();
        
        System.out.println(s2.secret);
        
    }
}
