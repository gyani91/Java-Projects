/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffimplement;

/**
 *
 * @author gyani
 */
public class MyArray implements IListMethods
{
    @Override
    public int count(){
        System.out.println("MyArray.count");
        return 0;
    }
    @Override
    public void add(Object o){
        System.out.println("MyArray.add");
    }
    @Override
    public void remove(Object o){
        System.out.println("MyArray.remove");
    }
}
