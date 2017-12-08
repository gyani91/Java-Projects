/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;
import java.awt.*;
/**
 *
 * @author gyani
 */
public class Grid extends Frame
{
    Button b1,b2,b3,b4,b5;
    public Grid()
    {
        //new FlowLayout();
        setLayout(new GridLayout(2,3));
        
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        b4=new Button("4");
        b5=new Button("5");
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        
        setVisible(true);
        
        setBounds(200,100,500,500);
        
     }
    
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grid d = new Grid();
    }
}
