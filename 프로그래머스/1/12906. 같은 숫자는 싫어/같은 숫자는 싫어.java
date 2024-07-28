import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> arrs = new ArrayList<>();
        int num = arr[0];
        arrs.add(num);
        
        for(int i=1 ; i < arr.length; i++){
            if(num != arr[i]){
                arrs.add(arr[i]);
                num = arr[i];
            }
        }
        int[] answer = new int[arrs.size()];
        int idx = 0;
        for(int i : arrs){
            answer[idx++] = i;
        }
        return answer;
    }
}