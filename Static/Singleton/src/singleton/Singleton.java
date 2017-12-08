/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author gyani
 */
public class Singleton {
    static Singleton p;
    int secret;
    private Singleton(){
        
    }
    static Singleton Create(){
        if(p == null)
            p = new Singleton();
        return p;
    }
    
}
