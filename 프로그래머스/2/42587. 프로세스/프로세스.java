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
                runIndexList[index++] = front[0];
            }
        }
        
        for(int x = 0; x < runIndexList.length; x++) {
            if(runIndexList[x] == location) answer = x + 1;
            
        }
        return answer;
    }
}