import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int size;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int s : scoville) {
			pq.add(s);
		}
		size = pq.size();
		
		while(pq.peek() < K) {
            if(pq.size() == 1) {
				answer = -1;
				break; 
			}
            pq.add(pq.poll() + (pq.poll()*2));
			answer++;
		}
		if(answer == size) answer = -1;
        
        return answer;
    }
}