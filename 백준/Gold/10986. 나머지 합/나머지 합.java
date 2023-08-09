import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 구간합 배열 생성
        long S[] = new long[N + 1];
        for(int i = 1; i < N + 1; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 구간합 배열을 M으로 나눈 C[] 생성
        long C[] = new long[M];
        long count = 0;
        for(int i = 1; i < N + 1; i++) {
            long remainder = S[i] % M;
            // 구간합을 M으로 나눈 나머지가 0이면 그 자체로 조건을 만족하므로 +1
            if(remainder == 0) count++;
            C[(int)remainder]++;
        }

        for(int i = 0; i < M; i++) {
            if(C[i] > 1) {
                count += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(count);
    }
}