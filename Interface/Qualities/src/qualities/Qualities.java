/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qualities;

/**
 *
 * @author gyani
 */
public class Qualities {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model m;
        
        Actor myself = new Actor();
        m=myself;
        m.style();
        
        ICharacter ch;
        ch=myself;
        ch.patriotism();
        
        myself.doActing();
    }
}
