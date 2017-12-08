/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancetypes;

/**
 *
 * @author gyani
 */
public class b extends a
{
    public void f2()
    {
        System.out.println("This is Using Overidden Method");
    }
    
    public void f3()
    {
        System.out.println("This is Using New Method");
    }
    
    public void f4()
    {
        super.f2();
        System.out.println("ing Combination Method");
    }
}
