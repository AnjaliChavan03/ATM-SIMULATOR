import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Balance extends ATM{
    public void Balcheck(int posn)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date date = new Date();
        Scanner c = new Scanner(System.in);

        int ch = -1;
        //Prints balance without A Receipt
        System.out.print("\n      AVAIL BAL       RS."+d[posn].balance+"        ");
        while (ch != 2) {
            System.out.println("\n  Do you want a Printed Receipt\n   Enter Choice:");
            System.out.println("     1.YES\n     2.NO");
            ch = c.nextInt();
            if (ch == 1) {
                break;
            } else if (ch == 2) {
            } else System.out.println("   INVALID CHOICE");
        }
        if(ch==1) {
            //Extracting last 4 digits
            try {
                String str = d[posn].cardno + "";
                String pr = str.substring(str.length() - 4);
                System.out.print("\n   -------------- RECEIPT --------------");
                System.out.print("\n  |                                     |");
                System.out.print("\n  |     DATE       TIME       ATM NO.   |");
                System.out.print("\n  |  " + formatter.format(date) + "      S1A45    |");
                System.out.print("\n  |                                     |");
                System.out.print("\n  |   CARD NO.  xxxxxxxxxxxx" + pr + "        |");
                System.out.print("\n  |                                     |");
                //System.out.print("\n  |   WITHDRAWAL      RS"+withdraw+"         |");
                //System.out.print("\n  |                                     |");
                // System.out.print("\n  |   LEDGER BAL      RS."+d[posn].balance+"       |");
                System.out.print("\n  |   AVAIL BAL       RS." + d[posn].balance + "        |");
                System.out.print("\n  |                                     |");
                System.out.print("\n   -------------------------------------");
            }
            catch (StringIndexOutOfBoundsException e){
                System.out.println("Card Number is too short for printing receipt");
                System.out.println("Enter Card Number which is aleast 4-digit long");
            }
        }
    }
}
