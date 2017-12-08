/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package absclass;
import java.io.*;
/**
 *
 * @author gyani
 */
public class JPEG extends Image
{
    public JPEG(String f)
    {
        setImage(f);
    }
    public void load()
    {
        System.out.println("Using JPEG.load");
    }
}
