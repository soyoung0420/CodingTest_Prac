import java.util.*;

class Solution {
    boolean solution(String s) {
        
       Stack<Character> str = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                str.push(s.charAt(i));
            } else if(s.charAt(i) == ')'){
                if(str.isEmpty()){
                    return false;
                }
                str.pop();
            }
        }
        return str.isEmpty();
    }
}