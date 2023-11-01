class Solution {
    private void dfs(int n, int[][] computers, boolean[] visited, int i) {
        visited[i] = true;
        for(int j = 0; j < computers[i].length; j++) {
            if(i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(n, computers, visited, j);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(n, computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
}