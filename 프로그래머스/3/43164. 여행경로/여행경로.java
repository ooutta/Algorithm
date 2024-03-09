import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> gragh = new HashMap<>();
        
        for(String[] ticket : tickets) {
            gragh.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        dfs("ICN", gragh, result);
        return result.toArray(String[]::new);
    }
    
    private void dfs(String departure, Map<String, PriorityQueue<String>> gragh, LinkedList<String> result) {
        PriorityQueue<String> arrivals = gragh.get(departure);
        
        while(arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), gragh, result);
        }
        
        result.addFirst(departure);
    }
}