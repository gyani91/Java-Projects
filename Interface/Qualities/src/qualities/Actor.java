/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qualities;

/**
 *
 * @author gyani
 */
public class Actor extends Model implements ICharacter
{
    public void style()
    {
        super.style();
        System.out.println("Actor.style");
    }
    
    public void patriotism()
    {
        System.out.println("Character.patriotism");
    }
    
    public void doActing()
    {
        System.out.println("Actor.doActing");
    }
            
}
