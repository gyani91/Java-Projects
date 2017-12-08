/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package focusview;

/**
 *
 * @author gyani
 */
public class FocusView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Demo o = new Demo();
        
        IEncrypt ie=o;
        ie.encrypt();
        ie.decrypt();
        
        IAuth ia=o;
        ia.logIn();
        ia.logOut();
        
        ICompress ic=o;
        ic.compress();
        ic.decompress();
    }
}
