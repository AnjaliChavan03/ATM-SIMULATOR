import java.util.InputMismatchException;
import java.util.Scanner;

public class Data {
    String name;
    int pin;
    long cardno;
    double balance;
    //String acctype;
    int cardblock=0;//Variable for checking if card has been blocked previously or not
    public void getData()
    {
        //Exception Handling Implemented to prevent InputMismatch
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Enter Name of the Card Holder:");
            name = sc.next();
            System.out.println("Enter VALID 16-digit Card number:");
            cardno = sc.nextLong();
            System.out.println("Enter VALID 4-digit PIN:");
            pin = sc.nextInt();
            //System.out.println("Enter Account Type: \nSaving or Current");
            //acctype = sc.next();
            System.out.println("Enter Account Balance: ");
            balance = sc.nextDouble();
            cardblock=0;
        }
        catch (InputMismatchException e){
            System.out.println("    WRONG INPUT ");
            System.out.println(" Re-ENTER DATA FOR THE SAME PERSON ");
            System.out.println("-----------------------------------------------");
            getData();
        }
    }
}
