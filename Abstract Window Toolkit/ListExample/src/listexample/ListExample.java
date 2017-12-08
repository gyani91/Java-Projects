/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listexample;
import java.awt.*;
/**
 *
 * @author gyani
 */
public class ListExample extends Frame
{
    public ListExample()
    {
        setLayout(new FlowLayout());
        List list = new List(4,true);
        // here 4 the capacity of the dropdown, you need to scroll if you add other items
        // you can select multiple item by pressing ctrl key
        // If you want to select only 1 item, set the agrument to false
        
        list.add("Mercury");
        list.add("Lithium");
        list.add("Silicon");
        list.add("Uranium");
        list.add("Sodium");
        
        add(list);
        setVisible(true);
        setSize(400,400);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new ListExample();
        // TODO code application logic here
    }
}
