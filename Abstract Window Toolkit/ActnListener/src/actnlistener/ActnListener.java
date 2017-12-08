/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actnlistener;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author gyani
 */
public class ActnListener extends Frame
{
    Button btn = new Button("Click me");
    public ActnListener()
    {
        add(btn);
        btn.addActionListener(new ActionListener()
        {
            
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("I was Clicked !!");
            }
                    
        });
        setVisible(true);
        setSize(100,100);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ActnListener a = new ActnListener();
    }
}
