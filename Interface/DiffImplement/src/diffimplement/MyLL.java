/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffimplement;
/**
 *
 * @author gyani
 */
public class MyLL implements IListMethods
{
    @Override
    public int count(){
        System.out.println("MyLL.count");
        return 0;
    }
    @Override
    public void add(Object o){
        System.out.println("MyLL.add");
    }
    @Override
    public void remove(Object o){
        System.out.println("MyLL.remove");
    }
            
}
