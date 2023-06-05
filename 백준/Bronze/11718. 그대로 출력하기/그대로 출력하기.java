import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		String text;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ((text = br.readLine()) != null) {
			System.out.println(text);
		}
	}
}