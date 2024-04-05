// Receipt.java
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Receipt extends Withdraw
{
	public void printReceipt(int posn,double withdraw, double ledgebal)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");  
    		Date date = new Date();
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
			System.out.print("\n  |   WITHDRAWAL      RS" + withdraw + "         |");
			System.out.print("\n  |                                     |");
			System.out.print("\n  |   LEDGER BAL      RS." + ledgebal + "        |");
			System.out.print("\n  |   AVAIL BAL       RS." + d[posn].balance + "        |");
			System.out.print("\n  |                                     |");
			System.out.print("\n   -------------------------------------");
		}
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Card Number is too short for printing receipt");
			System.out.println("Enter Card Number which is aleast 4-digit long");
		}
	}
}