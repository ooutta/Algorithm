import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashSet<String> setMap = new HashSet<>();
        List<String> duplicateNameList = new ArrayList<>();
        
        for(String name : participant) {
            if(!setMap.contains(name))
                setMap.add(name);
            else 
                duplicateNameList.add(name);
        }
        for(String name : completion) {
            if(setMap.contains(name)) {
                setMap.remove(name);
            } else if(duplicateNameList.contains(name)) {
                duplicateNameList.remove(name);
            }
        }
        
        if(setMap.size() > 0) {
            Iterator<String> iter = setMap.iterator();
            return iter.next();
        } 
        else {
            Iterator<String> iter = duplicateNameList.iterator();
            return iter.next();
        }
    }
}
