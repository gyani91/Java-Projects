/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package awtcontroldemo;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gyani
 */
public class AwtControlDemo 
{
    private Frame mainFrame;
    private Label headerLabel, statusLabel;
    private Panel controlPanel;
    
    public AwtControlDemo()
    {
       prepareGUI(); 
    }
    private void prepareGUI()
    {
        mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);
        
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
        
        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }
    
    private void showCheckBoxDemo()
    {
        headerLabel.setText("Control in action : Checkbox");
        Checkbox chkApple = new Checkbox("Apple");
        Checkbox chkMango = new Checkbox("Mango");
        Checkbox chkPeer = new Checkbox("Peer");
        
        chkApple.addItemListener(new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        statusLabel.setText("Apple Checkbox : " + (e.getStateChange() == 1 ? "Checked" : "Unchecked"));
                    }
                });
        chkMango.addItemListener(new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        statusLabel.setText("Mango Checkbox : " + (e.getStateChange() == 1 ? "Checked" : "Unchecked"));
                    }
                });
        chkPeer.addItemListener(new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        statusLabel.setText("Peer Checkbox : " + (e.getStateChange() == 1 ? "Checked" : "Unchecked"));
                    }
                });
        controlPanel.add(chkApple);
        controlPanel.add(chkMango);
        controlPanel.add(chkPeer);
        
        mainFrame.setVisible(true);
        
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        AwtControlDemo demo = new AwtControlDemo();
        demo.showCheckBoxDemo();
    }
}
