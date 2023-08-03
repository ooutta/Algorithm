import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int startIndex = 1, endIndex = 1, count = 1, sum = 1;
        while(endIndex < N) {
             if(sum < N) {
                endIndex++;
                sum += endIndex;
            } else if(sum > N){
                sum -= startIndex;
                startIndex++;
            } else { // sum == N
                count++;
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(count);
    }
}