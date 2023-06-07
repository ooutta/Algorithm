import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String str, printStr = "";
		char firstStr, lastStr;
		for(int i = 0; i < t; i++) {
			str = sc.next();
			
			firstStr = str.charAt(0);
			lastStr = str.charAt(str.length() - 1);
			printStr += "" + firstStr + lastStr + "\n";
		}
		System.out.println(printStr);
	}
}