import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Map<Integer,Integer>> queue = new LinkedList<>();
        int idx = 0;
        for(int p : priorities){
            Map<Integer,Integer> map = new HashMap<>();
            map.put(idx, p);
            queue.offer(map);
            idx++;
        }
        Arrays.sort(priorities);
        int j = priorities.length -1;
        int order = 1;
        
       while(!queue.isEmpty()){           
            Map<Integer,Integer> item = queue.poll();           
            int currentIdx = 0;
            int currentPrior = 0;

            for (Map.Entry<Integer, Integer> elem : item.entrySet()) {
                currentIdx = elem.getKey();
                currentPrior = elem.getValue();
            }
            
            if(currentPrior == priorities[j]){
                if(currentIdx == location){
                    break;
                }  
                j--;
                order++;
            }else{
                queue.offer(item);
            }                              
        }     
        return order;
    }
}