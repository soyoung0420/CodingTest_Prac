import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 반복되는 숫자만큼만 각 배열에 담기 
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 
        
        // 공통되는 요소를 메소드로 구현해서 간단하게 표현
        int cnt1 = answerCnt(p1, answers);
        int cnt2 = answerCnt(p2, answers);
        int cnt3 = answerCnt(p3, answers);
        
        // 각 cnt를 Math.max 메소드를 통해 구하기
        int maxCnt = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        // 순서대로 배열에 담기 위해 ArrayList를 사용하여 담았다. 
        List<Integer> cntList = new ArrayList<>();
        if(cnt1 == maxCnt) cntList.add(1);
        if(cnt2 == maxCnt) cntList.add(2);
        if(cnt3 == maxCnt) cntList.add(3);
        
        // Integer타입의 ArrayList -> int[]로 변환 
        int[] answer = new int[cntList.size()];
        for(int i = 0; i < cntList.size(); i++){
            answer[i] = cntList.get(i);
        }   
        return answer;
    }
    
    public int answerCnt(int[] player, int[] answer){
        int cnt = 0;   
        /*수포자의 배열과 정답 배열을 매개변수로 받아
        정답의 길이만큼 반복문을 시행, 
        수포자 배열의 index는 배열길이만큼 반복됨으로 i%player.length를 index로 해서 
        answer의 index와 비교해주었다. 
        값이 동일할때마다 cnt 증가연산 진행하고 그 cnt를 반환해주는 메소드로 작성. 
        */
        for(int i = 0; i < answer.length; i++){
           if(answer[i] == player[i%player.length]){
                  cnt++;
          }
        }
        return cnt;
    }
}