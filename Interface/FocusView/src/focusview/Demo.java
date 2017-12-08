/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package focusview;

/**
 *
 * @author gyani
 */
public class Demo implements IAuth, IEncrypt, ICompress
{
    @Override
    public void logIn()
    {
        System.out.println("Log in");
    }
    @Override
    public void logOut()
    {
        System.out.println("Log out");
    }
    
    @Override
    public void encrypt()
    {
        System.out.println("Encrypt");
    }
    
    @Override
    public void decrypt()
    {
        System.out.println("Decrypt");
    }
    
    @Override
    public void compress()
    {
        System.out.println("Compress");
    }
    
    @Override
    public void decompress()
    {
        System.out.println("Decompress");
    }
    
}
