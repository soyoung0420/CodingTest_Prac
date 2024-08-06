import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxMax = 0;
        int minMax = 0;
        
       for(int[] size : sizes){
           
           int max = Math.max(size[0], size[1]);
           int min = Math.min(size[0], size[1]);
           
           maxMax = Math.max(maxMax, max);
           minMax = Math.max(minMax, min);
           
       }
        
        return maxMax * minMax;
    }

}

