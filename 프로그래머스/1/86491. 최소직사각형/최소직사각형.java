import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        // 큰 값중에서 큰값과 작은 값중에서 큰값을 담을 변수 선언
        int maxMax = 0;
        int minMax = 0;
       
        for(int i =0 ; i < sizes.length; i++){
           // 명함의 가로와 세로중 가장 긴변을 max에 담고, 가장 짧은 변을 min에 담는다. 
           int max = Math.max(sizes[i][0], sizes[i][1]);
           int min = Math.min(sizes[i][0], sizes[i][1]);
           
           // 가장 긴변끼리 비교했을 때 가장 긴변, 짧은 변 중에서 가장 긴 변을 찾기
           maxMax = Math.max(maxMax, max);
           minMax = Math.max(minMax, min);     
        }
      
        // 그때에 두 길이의 곱이 모든 명함을 포함하게 된다. 
        return maxMax * minMax;
    }
}

