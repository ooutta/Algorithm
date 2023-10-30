import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> reserveList = new ArrayList<>();
        for(int r : reserve) {
            reserveList.add(r);
        }
        Arrays.sort(lost);
        List<Integer> lostList = new ArrayList<>();
        for(int l : lost) {
            lostList.add(l);
        }
        
        
        // 여분의 체육복을 도난 당한 학생을 lost와 reverse에서 제거
        for(int i = 0; i < lost.length; i++) {
            if(reserveList.contains(lost[i])) {
                reserveList.remove(reserveList.indexOf(lost[i]));
                lostList.remove(lostList.indexOf(lost[i]));
            }
        }
        
        for(int i = 0; i < lostList.size(); i++) {
            int back = lostList.get(i) - 1;
            int front = lostList.get(i) + 1;
            
            if(reserveList.contains(back)) {
                reserveList.remove(reserveList.indexOf(back));
                lostList.remove(lostList.indexOf(back + 1));
                i--;
            } 
            
            else if(reserveList.contains(front)) {
                reserveList.remove(reserveList.indexOf(front));
                lostList.remove(lostList.indexOf(front - 1));
                i--;
            }
        }
        return n - lostList.size();
    }
}