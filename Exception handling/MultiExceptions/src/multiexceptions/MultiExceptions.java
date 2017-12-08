/*
 * At a time only one catch block goes to work
 * order of catch blocks is important ( it should be from derived to base)
 */
package multiexceptions;
import java.io.*;

/**
 *
 * @author gyani
 */
public class MultiExceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int i,j;
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            try
            {
            System.out.println("Enter i:");
            i = Integer.parseInt(b.readLine());
            System.out.println("Enter j:");
            j = Integer.parseInt(b.readLine());
            
            System.out.printf("You enter : %d %d\n", i, j);
            System.out.println("Result: " + i/j);
            break;
            }
            catch(NumberFormatException ne)
            {
            System.out.println("Incorrect Input");
            }
            catch(ArithmeticException ae)
            {
            System.out.println("Arithmetic Exception like division by 0");
            }
            catch(Exception e)
            {
            System.out.println("Unknown Error:" + e);
            }
        }
    }
}
