import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] p1 = {1,2,3,4,5}; //5
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10
        
        int cnt1 = answerCnt(p1, answers);
        int cnt2 = answerCnt(p2, answers);
        int cnt3 = answerCnt(p3, answers);
        
        int maxCnt = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        List<Integer> cntList = new ArrayList<>();
        if(cnt1 == maxCnt) cntList.add(1);
        if(cnt2 == maxCnt) cntList.add(2);
        if(cnt3 == maxCnt) cntList.add(3);
        
        int[] answer = new int[cntList.size()];
        for(int i = 0; i < cntList.size(); i++){
            answer[i] = cntList.get(i);
        }   
        return answer;
    }
    
    public int answerCnt(int[] player, int[] answer){
        int cnt = 0;        
        for(int i = 0; i < answer.length; i++){
           if(answer[i] == player[i%player.length]){
                  cnt++;
          }
        }
        return cnt;
    }
}