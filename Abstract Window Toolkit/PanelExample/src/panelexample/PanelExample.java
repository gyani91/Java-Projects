/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelexample;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author gyani
 */
public class PanelExample extends Frame
{
    TextField tf = new TextField();
    Panel btnPanel = new Panel();
    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    Button b0 = new Button("0");
    Button plus = new Button("+");
    Button minus = new Button("-");
    Button mul = new Button("*");
    Button div = new Button("/");
    
    public PanelExample()
    {
        setLayout(new BorderLayout());
        add(tf,BorderLayout.NORTH);
        add(btnPanel,BorderLayout.CENTER);
        //add(btnPanel, new BorderLayout(4,4));
        btnPanel.add(b1);
        btnPanel.add(b2);
        btnPanel.add(b3);
        btnPanel.add(b4);
        btnPanel.add(b5);
        btnPanel.add(b6);
        btnPanel.add(b7);
        btnPanel.add(b8);
        btnPanel.add(b9);
        btnPanel.add(b0);
        btnPanel.add(plus);
        btnPanel.add(minus);
        btnPanel.add(mul);
        btnPanel.add(div);
        
        setSize(400,400);
        setVisible(true);    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new PanelExample();
        // TODO code application logic here
    }
}
