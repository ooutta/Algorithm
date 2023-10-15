import java.util.*;

class Solution {
    
    class Point {
        int x, y, dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    private int bfs(int[][] maps, int x, int y) {
        int move[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
        int row = maps.length, col = maps[0].length;
        boolean[][] visited = new boolean[row][col];
        visited[x][y] = true;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 1));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x == row - 1 && p.y == col - 1) return p.dist;
            // System.out.println("p.x : " + p.x + ", p.y : " + p.y);
            
            for(int i = 0; i < 4; i++) {
                int moveX = p.x + move[i][0], moveY = p.y + move[i][1];
                
                // 이동 범위가 map을 벗어나는 경우
                if(moveX < 0 || moveX > row - 1 || moveY < 0 || moveY > col - 1) 
                    continue;
                
                // 이미 방문한 칸인 경우
                if(visited[moveX][moveY]) continue;
                
                // 벽인 경우
                if(maps[moveX][moveY] == 0) continue;
                
                visited[moveX][moveY] = true;
                // System.out.println("moveX : " + moveX + ", moveY : " + moveY + ", dist : " + p.dist);
                queue.offer(new Point(moveX, moveY, p.dist + 1));
            }
            // System.out.println();
        }
        return -1;
    }
    public int solution(int[][] maps) {
        return bfs(maps, 0, 0);
    }
}
