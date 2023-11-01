import java.util.*;

class Solution {
    String[] words;
    class Node {
        String begin; // 변환할 글자
        int depth; // 변환 횟수

        Node(String begin, int depth) {
            this.begin = begin;
            this.depth = depth;
        }
    }
    
    // begin과 word가 변환할 수 있는지 확인. 한 개의 알파벳만 다른 경우 true 리턴
    private boolean check(String begin, String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) count++;
        }
        return count == 1;
    }
    
    private int bfs(String begin, String target) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node pop = q.poll();
            if(pop.begin.equals(target)) {
                answer = pop.depth;
                break;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && check(pop.begin, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], pop.depth + 1));
                }
            }
        }
        return answer;
    }
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        return bfs(begin, target);
    }
}