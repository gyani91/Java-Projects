/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buttoncolor;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gyani
 */
public class ButtonColor extends Frame
{
    Button b1;
    int MAX=0,MIN=250,r,g,b;
    
    public ButtonColor()
    {
        b1 =  new Button("Click me");
        b1.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                r = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
                g = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
                b = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
                setBackground(new Color(r,g,b));
            }
        });
        add(b1);
        b1.setBounds(150, 150, 200,200);
        //b1.setSize(50, 50);
        setLayout(null);
        setVisible(true);
        //setSize(500,500);
        setBounds(100,100,500,500);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ButtonColor b = new ButtonColor();
    }
}