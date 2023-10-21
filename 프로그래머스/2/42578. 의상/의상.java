import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0, count = 1;
        Map<String, Integer> category = new HashMap<>(); 
        
        for(String[] cloth : clothes) {
            category.put(cloth[1], category.getOrDefault(cloth[1], 0) + 1);
        }
        
        if(category.size() > 0) {
            for(String key : category.keySet()) {
                count *= category.get(key) + 1;
            }
            answer = count - 1;
        }
        return answer;
    }
}