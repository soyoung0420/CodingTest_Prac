import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String num = Long.toString(n);
        Character[] c = new Character[num.length()];
        for(int i = 0; i < num.length(); i++){
            c[i] = num.charAt(num.length()-i-1);
        }
        Arrays.sort(c, Collections.reverseOrder());
        String number = "";
        for(int i = 0; i<c.length; i++){
            number += c[i];
        }        
        return Long.parseLong(number);
    }
}