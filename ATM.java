/**
 *                          JAVA MINI PROJECT: ATM SIMULATOR
 *
 *              Project by: Vedant Borkar
 *                          Shreya Bhatia
 *                          Anjali Chavan
 * */
import java.util.*;
public class ATM {

    static Data d[]=new Data[1];//Number of customers
    static int validate=0,pinvalid=0,pcvalid=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("      WELCOME TO THE ATM SIMULATOR             \n");
        System.out.println("INPUT TO INITIALISE THE DATA FOR THE SIMULATOR");
        System.out.println("ENTER THE VALID CARD DETAILS FOR 3 People:");
        System.out.println("-----------------------------------------------");

        //Enter Data for the cardholders
        for (int i = 0; i < 1; i++) {//Change Customer number here as well
            d[i] = new Data();
            System.out.println("   ENTER Details for Person no. " + (i + 1));
            d[i].getData();
            System.out.println("-----------------------------------------------");
        }

        //Object creation for ATM Functions
        Withdraw w=new Withdraw();
        Balance b=new Balance();
        PinChange pc=new PinChange();


        //ATM SIMULATOR STARTS
        int exitter=0;/**EXITTER to continue simulation or terminate*/
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("      WELCOME TO THE ATM SIMULATOR             \n\n");
            System.out.println("-----------------------------------------------");
            int tries = 3;//3 tries for verifying card number
            double withdraw;

            int posn = -1;//POSN is the main variable as it stores which object's data is to be accessed


            /**Card number validation*/
            //Exception Handling Implemented to prevent InputMismatch
            while (tries-- != 0) {
                long cno=0;
                try {
                    System.out.println("           INSERT CARD NO.");
                    cno = sc.nextLong();
                    posn = Cardno(cno);
                    if (posn != -1 && d[posn].cardblock!=1) {
                        System.out.println("    CARD VALIDATED!!");
                        validate++;
                        break;
                    }else if(posn != -1 && d[posn].cardblock==1){
                        System.out.println("  Card was Blocked\n Please Contact your Bank");
                        break;
                    }
                    else {
                        System.out.println("     INVALID CARD no.\n  No.of tries remaining = " + tries);
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("  WRONG INPUT TYPE ");
                    System.out.println("   Re-ENTER CardNo. ");
                    System.out.println("-----------------------------------------------");
                }
            }

            /**PIN validation**/
            if (validate > 0) {
                pinvalid = Pinno(posn);
            } else {
                System.out.println("           CARD BLOCKED!");
            }


            int ch=0;
            /**On Pin Validation RUN FURTHER **/
            if(pinvalid>0) {
                do {
                    System.out.println("-----------------------------------------------");
                    System.out.println("        ENTER CHOICE NO.:");
                    System.out.println("      1. For WITHDRAW");
                    System.out.println("      2. For BALANCE CHECK");
                    System.out.println("      3. For CHANGE PIN");
                    System.out.println("      4. For EXIT");
                    System.out.println("-----------------------------------------------");
                    ch= sc.nextInt();

                    switch(ch)
                    {
                        case 1:
                            System.out.println(" Enter Amount to be Withdrawn:");
                            withdraw= sc.nextDouble();
                            w.Withdrawn(withdraw,posn);
                            break;
                        case 2:
                            b.Balcheck(posn);
                            break;
                        case 3:
                            System.out.println("  Enter OLD PIN:");
                            pinvalid=Pinno(posn);
                            if(pinvalid>0)
                             pc.Change(posn);
                            break;
                        case 4: pinvalid=0;validate=0;//RESET Verification Variables
                            break;
                        default:
                            System.out.println("      INVALID CHOICE");
                    }
                    if(d[posn].cardblock==1)
                        break;
                }while(ch!=4);
            }

                pinvalid=0;validate=0;
                System.out.println("    Enter 1 to Exit ATM Simulation");
                System.out.println("    Enter any no. to continue Simulation");
            exitter=sc.nextInt();
        }while(exitter!=1);
    }
    
    //CARD Validation static function
    public static int Cardno(long cno) {
        int posn=-1;validate=0;//RESETTING to prevent errors
        for (int i = 0; i < 1; i++) {
            if (d[i].cardno == cno) {
                posn = i;
            }
        }
        return posn;
    }

    //PIN Validation static function
    public static int Pinno(int posn) {
        Scanner s=new Scanner(System.in);int tries=3;//3 incorrect Pin tries
        while(tries--!=0)
        {
            System.out.println("           ENTER PIN NUMBER:");
            int pinno=s.nextInt();
            if(pinno==d[posn].pin) {
               return 1;
            }
            else{
                System.out.println("           INCORRECT PIN\nNumber of tries remaining: " + tries);
            }
        }
        System.out.println("           CARD BLOCKED!");
        d[posn].cardblock=1;
        return 0;
    }
}