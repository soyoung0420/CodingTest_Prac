import java.util.Arrays;

class Solution {
    boolean solution(String s) {

        
        String[] str = s.split("");
        int pcnt = 0; 
        int ycnt = 0;

        for( String word : str){
            if(word.equals("P") || word.equals("p")){
                pcnt++;
            } else if(word.equals("Y") || word.equals("y")){
                ycnt++;
            }   
        }
        boolean answer = pcnt==ycnt? true: false;
        
        return answer;
    }
}