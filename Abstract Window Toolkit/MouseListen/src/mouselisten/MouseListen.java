/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mouselisten;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gyani
 */
public class MouseListen extends Frame 
{
    Button b1 = new Button ("Click Me");
    public MouseListen()
    {
        add(b1);
        b1.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                System.out.println("Its Entered");
            }
            public void mouseExited(MouseEvent e)
            {
                System.out.println("Its Exited");
            }
            public void mousePressed(MouseEvent e)
            {
                System.out.println("Its Pressed");
            }
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Its Clicked");
            }
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("Its Released");
            }
        });
        b1.setBounds(150, 150, 200,200);
        setLayout(null);
        setVisible(true);
        setBounds(100,100,500,500);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new MouseListen();
    }   
}
