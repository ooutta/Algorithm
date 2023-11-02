import java.io.*;
import java.util.*;

public class Main {
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int[][] data = new int[N][2];

      for(int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        data[i][0] = Integer.parseInt(st.nextToken());
        data[i][1] = Integer.parseInt(st.nextToken());
      }

      // 가격 기준 내림차순 정렬
      Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] s1, int[] s2) {
				return s2[1] - s1[1];
			}
      });

      int weight = 0, index = 0, answer = 0;
      while(weight < W) {
        if(data[index][0] > 0) {
          weight += 1;
          answer += data[index][1];
          data[index][0]--;
        } else {
          index++;
        }
      }
    
      System.out.println(answer);
    }
}
