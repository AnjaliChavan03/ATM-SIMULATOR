import java.util.*;
public class Withdraw  extends ATM{
    public void Withdrawn(double withdraw, int posn) {
        Scanner c = new Scanner(System.in);
        double ledgebal = d[posn].balance;
        if (withdraw >= ledgebal) {
            System.out.println("   AMOUNT EXCEED!!\n   INSUFFICIENT FUNDS");
        } else {
            d[posn].balance = d[posn].balance - withdraw;
            int ch = -1;
            System.out.println("  AMOUNT WITHDRAWN SUCCESSFULLY!!  ");
            while (ch != 2) {
                System.out.println("  Do you want a Printed Receipt\n   Enter Choice:");
                System.out.println("     1.YES\n     2.NO");
                ch = c.nextInt();
                if (ch == 1) {
                    Receipt r = new Receipt();
                    r.printReceipt(posn, withdraw, ledgebal);
                    break;
                } else if (ch == 2) {
                } else System.out.println("   INVALID CHOICE");
            }
        }
    }
}
