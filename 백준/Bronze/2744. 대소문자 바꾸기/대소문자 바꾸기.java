import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		String str = sc.next();
		String newStr = "";
		
		for(int i=0;i<str.length();i++) {
			if('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				newStr += Character.toUpperCase(str.charAt(i));
			}
			else {
				newStr += Character.toLowerCase(str.charAt(i));
			}
		}
		System.out.println(newStr);
	}
}