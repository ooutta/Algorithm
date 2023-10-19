import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashSet<Integer> map = new HashSet<>();
        
        for(int num : nums) {
            map.add(num);
        }

        return map.size() > n ? n : map.size();
    }
}