import java.util.*;

class Solution {
    public String solution(String s) {
        
       String[] strArr = s.split(" ",-1);
        
        StringBuilder result = new StringBuilder();
              
        for(int i = 0; i < strArr.length; i++){
            String word = strArr[i];
            StringBuilder newWord = new StringBuilder();
            for(int j = 0; j < word.length(); j++){
                 char ch = word.charAt(j);
                
                if(j == 0){
                    if(ch < '0' || ch > '9'){
                       newWord.append(Character.toUpperCase(ch));   
                    } else {
                        newWord.append(ch);
                    }           
                } else {
                    newWord.append(Character.toLowerCase(ch));
                }
                        
            }
            result.append(newWord);
            if(i < strArr.length-1){
                result.append(" ");
            }
        }
        String answer = result.toString();
        System.out.print(answer);
        return answer;
    }
}