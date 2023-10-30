import java.util.*;
import java.time.LocalDate;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // today를 LocalDate 타입으로 변환
        String[] todaySplitDate = today.split("\\."); 
        LocalDate todayDate = LocalDate.of(Integer.parseInt(todaySplitDate[0]),
                                                  Integer.parseInt(todaySplitDate[1]), 
                                            Integer.parseInt(todaySplitDate[2]));
        
        // terms의 "약관종류 유효기간" split
        Map<String, Integer> termMaps = new HashMap<>();
        for(String term : terms) {
            String[] termSplit = term.split(" ");
            termMaps.put(termSplit[0], Integer.parseInt(termSplit[1].split("달")[0]));
        }
        
        // privacies의 "날짜 약관종류" split
        List<Integer> result = new ArrayList<>();  
        int number = 1;
        for(String privacie : privacies) {
            String[] privacieSplit = privacie.split(" ");
            String[] privacieSplitDate = privacieSplit[0].split("\\."); 
            LocalDate privacieDate = LocalDate.of(Integer.parseInt(privacieSplitDate[0]),
                                                  Integer.parseInt(privacieSplitDate[1]), 
                                                  Integer.parseInt(privacieSplitDate[2]));
            
            LocalDate plusDate = privacieDate.plusMonths(termMaps.get(privacieSplit[1]));
            // plusDate가 todayDate보다 클 때
            if(plusDate.compareTo(todayDate) <= 0) {
                result.add(number);
            }
            number++;
        }
        
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}