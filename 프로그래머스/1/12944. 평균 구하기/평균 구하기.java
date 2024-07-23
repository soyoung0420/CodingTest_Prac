class Solution {
    public double solution(int[] arr) {
      
        int sum = 0;
        for(int elem : arr){
            sum += elem;     
        }
        double answer = sum/(double)arr.length;
        return answer;
    }
}