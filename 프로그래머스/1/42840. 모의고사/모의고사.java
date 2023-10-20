import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        Integer[] answer = {0,0,0};
        
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i < answers.length; i++) {
            if(person1[i % person1.length] == answers[i]) answer[0]++;
            if(person2[i % person2.length] == answers[i]) answer[1]++;
            if(person3[i % person3.length] == answers[i]) answer[2]++;
        }
        
        List<Integer> list = new ArrayList<>(Arrays.asList(answer));
        
        int max = Collections.max(list);
        
        List<Integer> test = new ArrayList<>();
        test.add(list.indexOf(max) + 1);
        
        for(int i = 0; i < list.size(); i++) {
            if(i != list.indexOf(max)
               && max == list.get(i)) test.add(i+1);
        }
        
        return test.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}