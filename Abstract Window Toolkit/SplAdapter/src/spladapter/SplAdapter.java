/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spladapter;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gyani
 */
public class SplAdapter extends Frame
{
    public SplAdapter()
    {
        addWindowListener(new WindowAdapter()
        {
           public void windowIconified(WindowEvent e)
           {
               dispose();
               System.out.println("Iconified");
           } 
        });
        setLayout(null);
        setVisible(true);
        setSize(400,400);

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new SplAdapter();
    }
}
