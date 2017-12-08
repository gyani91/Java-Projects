/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package absclass;

/**
 *
 * @author gyani
 */
public class Sample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image i = Image.Create("gyani.jpg");//Upcasting
        i.load();//Dynamic Dispatch Mechanism
        i = Image.Create("gyani.GIF");
        i.load();
    }
}
