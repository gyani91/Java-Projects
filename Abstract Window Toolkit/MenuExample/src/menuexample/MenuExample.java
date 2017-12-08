/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuexample;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author gyani
 */
public class MenuExample extends Frame
{
    MenuBar mb = new MenuBar();
    Menu file = new Menu("File");
    Menu edit = new Menu("Edit");
    MenuItem n = new MenuItem("New");
    MenuItem o = new MenuItem("Open");
    MenuItem e = new MenuItem("Exit");
    MenuItem cut = new MenuItem("Cut");
    MenuItem copy = new MenuItem("Copy");
    MenuItem paste = new MenuItem("Paste");
    
    TextArea ta = new TextArea();
    
    public MenuExample()
    {
        setLayout(new BorderLayout());
        add(ta,BorderLayout.CENTER);
        setMenuBar(mb);
        mb.add(file);
        mb.add(edit);
        
        file.add(n);
        file.add(o);
        file.add(e);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        
        n.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ta.setText("New");
            }
        });
        
        setVisible(true);
        setSize(400,400);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new MenuExample();
        // TODO code application logic here
    }
}
