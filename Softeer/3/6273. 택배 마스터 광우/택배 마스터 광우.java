import java.io.*;
import java.util.*;

public class Main {
    /*
      n : 레일 개수
      m : 택배 바구니 무게
      k : 일 시행 횟수
      rails : 각 레일의 전용 무게
      output : 순열로 방문한 레일의 순서
      visited : 각 레일 방문 여부
    */
    static int n, m, k, answer;
    static int[] rails, output;
    static boolean[] visited;
  
    public static void dfs(int depth) {
      if(depth == n) {
        int sum = 0, index = 0;
        for(int i = 0; i < k; i++) {
          int box = 0;
          while(true) {
            if(box + output[index%n] <= m) {
              box += output[index%n];
            }
            else break;
            index++;
          }
          sum += box;
        }
        answer = Math.min(answer, sum);
        return;
      }
      
      for(int i = 0; i < n; i++) {
        if(!visited[i]) {
          visited[i] = true;
          // 원소 i를 순열에 추가 
          output[depth] = rails[i]; // depth : 현재 순열의 길이.
          dfs(depth + 1);
          visited[i] = false; // 백트래킹
        }
      }
    }
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      rails = new int[n];
      output = new int[n];
      visited = new boolean[n];
      st = new StringTokenizer(br.readLine());
      
      for(int i = 0; i < n; i++) {
        rails[i] = Integer.parseInt(st.nextToken());
      }

      answer = Integer.MAX_VALUE;
      dfs(0);
      
      System.out.println(answer);
    }
}
