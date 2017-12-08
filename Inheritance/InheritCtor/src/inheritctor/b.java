/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritctor;

/**
 *
 * @author gyani
 */
public class b extends a
{
    public b()
    {
        // If super is absent a's 0-arg Ctor is called
        System.out.println("b's 0-arg Ctor");
    }
    
    public b(int x)
    {
        super(x);
        System.out.println("b's 1-arg Ctor");
    }
}
