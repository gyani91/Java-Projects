/*
 * Code in finally block always run, no matter what!
 * Even if a return or break comes first. Exception: System.exit()
 * it is placed after catch blocks
 */
package finallyblock;
import java.io.*;
/**
 *
 * @author gyani
 */
public class FinallyBlock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        FileWriter fw = null;
        try
        {
            fw = new FileWriter("a.txt");
            fw.write("Hello World\n");
        }
        catch(IOException ex)
        {
            System.out.println("Encountered IO Error");
        }
        finally
        {
            if(fw != null)
            {
                try
                {
                    fw.close();
                    
                }
                catch(IOException ex)
                {
                    System.out.println("Cannot Close File");
                }
            }   
        }    
    }
}
