/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getsource;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gyani
 */
public class GetSource extends Frame implements ActionListener
{
    Button b1 = new Button("Hi");
    Button b2 = new Button("Hello");
    
    public GetSource()
    {
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        setVisible(true);
        setBounds(100,100,500,500);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
            System.out.println("Hi");
        else if(e.getSource() == b2)
            System.out.println("Hello");
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new GetSource();
    }
}
