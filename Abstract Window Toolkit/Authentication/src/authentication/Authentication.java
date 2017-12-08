/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;
import java.awt.*;

/**
 *
 * @author gyani
 */
public class Authentication extends Frame
{
    Button login, cancel;
    Label u,p;
    TextField username, password;
    
    public Authentication()
    {
        login = new Button("Login");
        cancel = new Button("Cancel");
        u=new Label("Username");
        p=new Label("Password");
        
        username=new TextField();
        password= new TextField();
        
        setLayout(null);
        u.setBounds(20, 40, 100, 20);
        username.setBounds(140, 40, 100, 20);
        p.setBounds(20, 80, 100, 20);
        password.setBounds(140, 80, 100, 20);
        login.setBounds(20, 120, 100, 20);
        cancel.setBounds(140, 120, 100, 20);
        
        add(u);add(username);add(p);
        add(password);add(login);add(cancel);
        
        setVisible(true); setSize(260,150);
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Authentication a = new Authentication();
    }
}
