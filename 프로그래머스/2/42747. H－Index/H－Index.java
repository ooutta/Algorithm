import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int h = 0; h < citations[citations.length - 1]; h++) {
        // for(int i = 1; i < citations.length; i++) {
            // int h = citations[i];
            // h번 이상 인용된 논문이 h편 이상
            int overCount = 0;
            for(int num : citations) {
                if(num >= h) overCount++;
            }
            
            // 전체 - h번 이상 인용된 논문이 h편 이상 <= h
            if(overCount >= h
               && citations.length - overCount <= h
              && answer < h) answer = h;
        } 
        return answer;
    }
}