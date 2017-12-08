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
abstract class Image
{
    protected String filename;
    public void setImage(String f)
    {
        this.filename=f;
    }
    public static Image Create(String f)//Class factory function
    {
        //Creates appropriate object based on extension
        if(f.toLowerCase().endsWith(".jpg"))
           return new JPEG(f);
        else if(f.toLowerCase().endsWith(".gif"))
            return new GIF(f);
        return null;
    }
    public void save(char[] buf)throws IOException
    {
        // Need not be abstract, How to save an image is same for every format
        FileWriter fw = new FileWriter(filename);
        fw.write(buf);
        fw.close();
    }
    public abstract void load();// Should be abstract , Each Type of image is loaded differently
            
            
}
