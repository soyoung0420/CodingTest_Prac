import java.util.*;

class Solution {
    public long solution(long n) {
        //long -> String으로 형변환 
        String num = Long.toString(n);
        
        // Character 배열 선언
        Character[] c = new Character[num.length()];
        
        // Character배열 c에 String num의 각 자리의 문자를 담기 
        for(int i = 0; i < num.length(); i++){
            c[i] = num.charAt(i);
        }
        
        // 배열을 내림차순으로 정렬
        // 큰 수가 아스키 코드값이 크기 때문에 큰 수부터 정렬이 된다.
        Arrays.sort(c, Collections.reverseOrder());
        String number = "";
        
        // 정렬된 c 배열의 값들을 문자열로 이어주기 
        for(int i = 0; i<c.length; i++){
            number += c[i];
        }  
        
        // 완성된 문자열을 Long타입으로 형변환 후 반환 
        return Long.parseLong(number);
    }
}