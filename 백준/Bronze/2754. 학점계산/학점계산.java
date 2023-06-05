import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String grade = sc.next();
		
		float n = 0f;
		switch (grade) {
			case "A+": n = 4.3f; break;
			case "A0": n = 4.0f; break;
			case "A-": n = 3.7f; break;
			case "B+": n = 3.3f; break;
			case "B0": n = 3.0f; break;
			case "B-": n = 2.7f; break;
			case "C+": n = 2.3f; break;
			case "C0": n = 2.0f; break;
			case "C-": n = 1.7f; break;
			case "D+": n = 1.3f; break;
			case "D0": n = 1.0f; break;
			case "D-": n = 0.7f; break;
			default: n = 0f; break;
		};
		System.out.printf("%.1f", n);
	}
}