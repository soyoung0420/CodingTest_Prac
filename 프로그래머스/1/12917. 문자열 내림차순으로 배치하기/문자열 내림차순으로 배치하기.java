import java.util.*;

class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        Character[] strList = new Character[str.length];
        
        for(int i = 0; i < str.length; i++){
            strList[i] = str[i];
        }        
        Arrays.sort(strList, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(char c : strList){sb.append(c);};
        
        return sb.toString();
    }
}