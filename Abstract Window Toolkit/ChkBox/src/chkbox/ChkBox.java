/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chkbox;
import java.awt.*;
import java.awt.event.*;
//import java.awt.CheckboxGroup;
/**
 *
 * @author gyani
 */
public class ChkBox extends Frame
{
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox cb1 = new Checkbox("Male",true,cbg);
    Checkbox cb2 = new Checkbox("Female",false,cbg);
    
    public ChkBox()
    {
        setLayout(new FlowLayout());
        add(cb1);
        add(cb2);
        setVisible(true);
        setSize(400,400);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new ChkBox();
    }
}
