class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 가로와 세로 중 긴 길이를 찾는다
        // 이 긴 길이가 가로 길이가 되도록 회전시킨다
        // 그럼 나머지 세로 길이 중에서 가장 긴 길이를 찾는다
        // 여기서 구한 가장 긴 가로와 세로를 곱한다
        int[][] maxSizes = new int[sizes.length][2];
    
        for(int i = 0; i < sizes.length; i++) {           
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            maxSizes[i][0] = width;
            maxSizes[i][1] = height;
        }
    
        int width = maxSizes[0][0], height = maxSizes[0][1];
        for(int i = 1; i < maxSizes.length; i++) {
            if(maxSizes[i][0] > width) width = maxSizes[i][0];
            if(maxSizes[i][1] > height) height = maxSizes[i][1];
        }
        answer = width * height;
    
    
        return answer;
    }
}