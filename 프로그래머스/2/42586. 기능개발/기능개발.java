import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        int[] day = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) {
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                day[i]++;
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int d : day) {
            que.offer(d);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int front = que.poll();
        int count = 1;
        while(!que.isEmpty()) {
            int tail = que.poll();
            
            if(front < tail) {
                result.add(count);
                count = 1;
                front = tail;
            } else {
                count++;
            }
        }
        result.add(count);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}