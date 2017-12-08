/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package winlisten;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gyani
 */
public class WinListen extends Frame implements WindowListener
{
    public WinListen()
    {
        addWindowListener(this);
        //b1.setBounds(150, 150, 200,200);
        //b1.setSize(50, 50);
        setLayout(null);
        setVisible(true);
        //setSize(500,500);
        setBounds(100,100,500,500);
    }
    public void windowDeactivated(WindowEvent e)
    {
        System.out.println("Deactivated");
    }
    public void windowActivated(WindowEvent e)
    {
        System.out.println("Activated");
    }
    public void windowDeiconified(WindowEvent e)
    {
        System.out.println("Deiconified");
    }
    public void windowIconified(WindowEvent e)
    {
        System.out.println("Iconified");
    }
    public void windowClosed(WindowEvent e)
    {
        System.out.println("Closed");
    }
    public void windowClosing(WindowEvent e)
    {
        System.out.println("Closing");
    }
    public void windowOpened(WindowEvent e)
    {
        System.out.println("Opened");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new WinListen();
    }
}
