/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bound;
import java.awt.*;
/**
 *
 * @author gyani
 */
public class Bound extends Frame{
    Button b1,b2,b3,b4,b5;
    public Bound()
    {
        setLayout(new BorderLayout());
        
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        b4=new Button("4");
        b5=new Button("5");
        
        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.SOUTH);
        add(b3, BorderLayout.EAST);
        add(b4, BorderLayout.WEST);
        add(b5, BorderLayout.CENTER);
        
        setVisible(true);
        
        setBounds(200,100,500,500);
        
     }
    
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bound d = new Bound();
    }
}
