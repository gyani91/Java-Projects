/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;
import java.awt.*;

/**
 *
 * @author gyani
 */
public class ColorChooser extends Frame
{
    Choice colorChooser = new Choice();
    
    public ColorChooser()
    {
        setLayout(new FlowLayout());
        
        colorChooser.add("Green");
        colorChooser.add("Red");
        colorChooser.add("Blue");
        
        add(colorChooser);
        setVisible(true);
        setSize(400,400);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new ColorChooser();
    }
}
