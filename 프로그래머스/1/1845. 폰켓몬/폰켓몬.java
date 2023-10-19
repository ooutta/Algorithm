import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, 0);
        }

        if(map.size() > n) return n;
        else return map.size();
    }
}