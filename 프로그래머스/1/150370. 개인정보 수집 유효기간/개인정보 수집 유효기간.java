import java.util.*;
import java.time.LocalDate;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. today를 LocalDate 타입으로 변환
        String[] todaySplitDate = today.split("\\."); // "."으로 분할
        LocalDate todayDate = LocalDate.of(Integer.parseInt(todaySplitDate[0]),
                                                  Integer.parseInt(todaySplitDate[1]), 
                                            Integer.parseInt(todaySplitDate[2]));
        
        // 2. terms "약관종류 유효기간"를 split하여 Key-Value로 저장
        Map<String, Integer> termMaps = new HashMap<>();
        for(String term : terms) {
            String[] termSplit = term.split(" ");
            termMaps.put(termSplit[0], Integer.parseInt(termSplit[1].split("달")[0]));
        }
        
        List<Integer> result = new ArrayList<>();  
        int number = 1;
        for(String privacie : privacies) {
            // 3. privacies의 "날짜 약관종류"를 split
            String[] privacieSplit = privacie.split(" ");
            String[] privacieSplitDate = privacieSplit[0].split("\\."); 
            LocalDate privacieDate = LocalDate.of(Integer.parseInt(privacieSplitDate[0]),
                                                  Integer.parseInt(privacieSplitDate[1]), 
                                                  Integer.parseInt(privacieSplitDate[2]));
            
            // 개인정보 수집 일자에 약관 종류에 따른 유효 기간을 더함
            LocalDate plusDate = privacieDate.plusMonths(termMaps.get(privacieSplit[1]));
            
            // 더한 보관 가능한 일자(plusDate)가 오늘 날짜(todayDate)보다 클 때 result list에 저장
            if(plusDate.compareTo(todayDate) <= 0) {
                result.add(number);
            }
            number++;
        }
        
        // Integer list를 int array에 저장
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}