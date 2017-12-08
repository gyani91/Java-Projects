/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userdefined;

/**
 *
 * @author gyani
 */
public class UserDefined {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack s = new Stack(3);
        try
        {
            s.push("gyani");
            s.push(new Integer(25));
            s.push(new Float(3.14f));
            s.push("meenu");
        }
        catch(StackException ex)
        {
            System.out.println(ex);
        }
        
        try
        {
            while(s.getSize()>0)
                System.out.println(s.pop());
        }
        catch(StackException ex)
        {
            System.out.println(ex);
        }
            
    }
}
