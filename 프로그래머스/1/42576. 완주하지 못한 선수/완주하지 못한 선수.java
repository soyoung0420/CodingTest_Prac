import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> playerMap = new HashMap<>();
        int i = 0;
        for(String p : participant){
            playerMap.put(p, playerMap.getOrDefault(p, 0)+1);
        }
        for(String p : completion){
            playerMap.put(p, playerMap.getOrDefault(p, 0)-1);
        }
        String answer = "";
        for(String key : playerMap.keySet()){
             if(playerMap.get(key)!=0){
                 answer = key;
             }
        }
      
        return answer;
    }
}