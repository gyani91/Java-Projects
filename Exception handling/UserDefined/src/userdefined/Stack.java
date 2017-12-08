package userdefined;
 /**
 *
 * @author gyani
 */
public class Stack 
{
    private int capacity;
    private int size;
    private Object[] data;
    
    public Stack(int cap)
    {
        data = new Object[cap];
        capacity = cap;
        size = 0;
    }
    public void push(Object o) throws StackException
    {
        if(size==capacity)
        {
            throw new StackException("Stack Full !");
        }
        data[size++]= o;
    }
    public Object pop() throws StackException
    {
        if(size<=0)
        {
            throw new StackException("Stack Empty !");
        }
        return data[--size];
    }
    public int getSize()
    {
        return size;
    }
            
}

