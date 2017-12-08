/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritb2d;
import java.io.*;

/**
 *
 * @author gyani
 */
public class Der extends Base
{
    int k,j;
    public Der()
    {
        j = i*4;//Dependent on Base Class
        k=12;
        System.out.println(j);
        System.out.println(k+" "+super.k);//conflicted with Base Class
    }       
}
