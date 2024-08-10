import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = n - lost.length; //체육복 있는 학생수  
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌체육복 있는 학생이 도난 당한 경우, 다른 사람에게 빌려줄 수 없음 
        for(int i = 0; i < lost.length; i++){
            for(int j = 0 ; j < reserve.length; j++){
               if(reserve[j] == lost[i]){
                   cnt++;
                   reserve[j] = -1;
                   lost[i] = -1;
                   break;
               }
            }            
        }
        // 여벌체육복을 빌려줄 수 있는 경우 
        for(int i = 0; i < lost.length; i++){
            if(lost[i] == -1){continue;}
            
            for(int j = 0 ; j < reserve.length; j++){
               if(lost[i] == reserve[j]-1 || lost[i]==reserve[j]+1){
                   cnt++;
                   reserve[j] = -1;
                   break;
               }
            }            
        }
        
        return cnt;
    }
}