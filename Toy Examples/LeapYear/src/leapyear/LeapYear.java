/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leapyear;
import java.io.*;


/**
 *
 * @author gyani
 */
public class LeapYear 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        int yr;// TODO code application logic here
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter the Year");
        str = b.readLine();
        yr = Integer.parseInt(str);
        
        if(yr%100 == 0)
        {
            if(yr%400 == 0)
                System.out.println("Leap Year");
            else
                System.out.println("Not Leap Year");
        }
        else
        {
            if(yr%4 == 0)
                System.out.println("Leap Year");
            else
                System.out.println("Not Leap Year");
        }
    }
}
