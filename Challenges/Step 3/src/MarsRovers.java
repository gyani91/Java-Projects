/**
 * Created by Sumeet Gyanchandani on 4/9/2015.
 */
public class MarsRovers
{
    private int xmax;
    private int ymax;
    private int x;
    private int y;
    private int orientation;

    public MarsRovers(int xmax, int ymax, int x, int y, char orient)
    {
        this.x = x;
        this.y = y;
        this.xmax = xmax;
        this.ymax = ymax;

        switch(orient)
        {
            case 'N':
                this.orientation = 1;
                break;
            case 'E':
                this.orientation = 2;
                break;
            case 'S':
                this.orientation = 3;
                break;
            case 'W':
                this.orientation = 4;
                break;
            default:
                System.out.println("Invalid Orientation");
                System.exit(1);
                break;
        }

    }

    public void spliter(String instructions)
    {
        int length = instructions.length();

        for(int i =0; i<length; i++)
        {
            perform(instructions.charAt(i));
        }
    }

    private void perform(char instruction)
    {
        switch(instruction)
        {
            case 'L':
                turn(-1);
                break;
            case 'R':
                turn(1);
                break;
            case 'M':
                move();
                break;
            default:
                System.out.println("Invalid Instruction");
                System.exit(1);
                break;
        }
    }

    private void turn(int change)
    {
        orientation +=change;
        if(orientation == 5)
            orientation = 1;
        if(orientation == 0)
            orientation = 4;
    }

    private void move()
    {
        switch(orientation)
        {
            case 1:
                y++;
                break;
            case 2:
                x++;
                break;
            case 3:
                y--;
                break;
            case 4:
                x--;
                break;
        }
        //System.out.println(x + " " + y);
        validate_coordinates();
    }

    public void validate_coordinates()
    {
        if(x<0 || x>xmax || y<0 || y>ymax)
        {
            System.out.println("Rover just toppled over the plateau");
            System.exit(1);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getOrientation()
    {
        char orient = 'E';
        switch(orientation)
        {
            case 1:
                orient = 'N';
                break;
            case 2:
                orient = 'E';
                break;
            case 3:
                orient = 'S';
                break;
            case 4:
                orient = 'W';
                break;
        }
        return orient;
    }
}
