import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        
        int boxCnt = score.length / m ; 
        int[][] apple = new int[boxCnt][m];
        Arrays.sort(score);
        int idx = score.length-1;
        for(int i = 0; i < boxCnt; i++){
            for(int j = 0; j < m ; j++){                
                apple[i][j] = score[idx];
                idx--;                
            }            
        }
        int sum = 0;
        for(int i = 0; i < apple.length; i++){                
                sum += apple[i][m-1] * m;                                         
        }      
        return sum;
    }
}