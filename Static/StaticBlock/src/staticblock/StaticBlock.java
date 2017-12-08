/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staticblock;
import java.io.*;

/**
 *
 * @author gyani
 */
public class StaticBlock {
    static int x,y,z;
    static
    {
        x=10;
        y=20;
        z=x*y;
    }
    static void show()
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
