/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filedg;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gyani
 */
public class FileDg extends Frame 
{
    Button file = new Button("Window Box");
    
    public FileDg()
    {
        setLayout(new FlowLayout());
        add(file);
        file.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                FileDialog fd=new FileDialog(FileDg.this,"Open a File, Mate",FileDialog.LOAD);
                fd.setVisible(true);
                System.out.println(" " + fd.getFile());
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
        new FileDg();
        // TODO code application logic here
    }
}
