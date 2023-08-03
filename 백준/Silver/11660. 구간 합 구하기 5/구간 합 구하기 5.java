import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 행에 표의 크기 n, 합을 구해야 하는 횟수 m 입력받음
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken()); // 표의 크기
        int m = Integer.parseInt(stringTokenizer.nextToken()); // 합을 구해야 하는 횟수

        int array[][] = new int[n + 1][n + 1]; // 입력 요소를 저장하는 배열 
        int D[][] = new int[n + 1][n + 1]; // 입력 요소의 누적 합을 저장하는 배열

        // n행과 n열 만큼 입력받은 n*n개의 데이터를 2차원 배열 array에 저장
        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 각 배열 요소의 누적 합 저장
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + array[i][j];
            }
        }

        // m번 만큼 x1 y1 x2 y2 값 입력 받기
        int x1, y1, x2, y2;
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(stringTokenizer.nextToken());
            y1 = Integer.parseInt(stringTokenizer.nextToken());
            x2 = Integer.parseInt(stringTokenizer.nextToken());
            y2 = Integer.parseInt(stringTokenizer.nextToken());

            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];

            System.out.println(result);
        }
    }
}