/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staticvariable;

import java.io.*;

/**
 *
 * @author gyani
 */
public class StaticVariable {
    static int count;
    public StaticVariable(){
        count++;
    }
    public void show(){
        System.out.println("Count:"+count);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StaticVariable s1 = new StaticVariable();
        s1.show();
        StaticVariable s2 = new StaticVariable();
        s2.show();
        StaticVariable s3 = new StaticVariable();
        s3.show();
        StaticVariable s4 = new StaticVariable();
        s4.show();
        
        s1.show();
        s2.show();
        s3.show();
        s4.show();
    }
}
