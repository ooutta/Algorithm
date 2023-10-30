import java.util.*;

class Solution {
    int[][] matrix;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 인접 행렬로 wires 저장
        matrix = new int[n + 1][n + 1];
        
        for(int[] wire : wires) {
            matrix[wire[0]][wire[1]] = 1;
            matrix[wire[1]][wire[0]] = 1;
        }        
        
        // 하나씩 연결 잘라보기
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 선 끊기
            matrix[v1][v2] = 0;
            matrix[v2][v1] = 0;
            
            // 전력망 네트워크 2개로 분할 후 차이가 최소인 개수 구하기
            answer = Math.min(answer, bfs(v1, n));
            
            // 선 다시 연결
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }
        return answer;
    }
    
    private int bfs(int v1, int n) {
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        // 현재 위치를 큐에 insert 및 방문 처리
        q.offer(v1);
        visited[v1] = true;
        
        // 큐가 비어있지 않으면
        while(!q.isEmpty()) {
            // 큐에 삽입된 첫번째 송전탑과
            int temp = q.poll();
            for(int i = 1; i <= n; i++) {
                // 전선으로 연결되어있고, 방문하지 않은 송전탑을 큐에 삽입
                if(matrix[temp][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return Math.abs(n-2*count);
    }
}