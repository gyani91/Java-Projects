/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package absclass;

/**
 *
 * @author gyani
 */
public class GIF extends Image
{
    public GIF(String f)
    {
        setImage(f);
    }
    public void load()
    {
        System.out.println("Using GIF.load");
    }
}
