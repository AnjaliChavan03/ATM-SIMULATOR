import java.util.*;
public class PinChange extends  ATM{
    public void Change(int posn)
    {
        Scanner sc=new Scanner(System.in);
        int tries=3;
        while(tries-->0)
        {
        System.out.println("  ENTER NEW PIN:");
        int newpin=sc.nextInt();
        System.out.println("RE-ENTER NEW PIN:");
        int repin=sc.nextInt();

            if(newpin==repin){
                d[posn].pin=newpin;
                System.out.println("PIN CHANGED SUCCESSFULLY");
                break;
            }
            else{
                System.out.println("Entered PIN Do not match Re-enter PINS");
                System.out.println("Number of tries remaining: " +tries);
            }
        }

    }
}
