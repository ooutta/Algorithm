import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // [기존 프로세스 인덱스, 우선순위 값]
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            que.add(new int[]{i, priorities[i]});
        }
        
        int[] runIndexList = new int[priorities.length];
        int index = 0;
        while(!que.isEmpty()) {
            int[] front = que.poll();
            
            boolean isMaxPriority = true;
            for(int[] q : que) {
                if(front[1] < q[1]) {
                    isMaxPriority = false;
                    break;
                }
            }
            
            if(!isMaxPriority) {
                que.add(front);
            } else {
                answer++;
                if(front[0] == location) return answer;
            }
        }
        return answer;
    }
}
