/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleinterest;
import java.io.*;


/**
 *
 * @author gyani
 */
public class SimpleInterest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        float p,r,si;
        int n;
        BufferedReader b = new BufferedReader (new InputStreamReader(System.in));
        String str;
        System.out.println("Enter the Values");        
        
        str = b.readLine();
        p = Float.parseFloat(str);
        str = b.readLine();
        n = Integer.parseInt(str);
        str = b.readLine();
        r = Float.parseFloat(str);
        
        si=p*n*r/100;
        System.out.println("The Simple Interest is " + si);
    }
}
