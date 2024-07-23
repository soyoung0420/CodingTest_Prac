class Solution {
    public long[] solution(long x, int n) {
              
        long[] arr= new long[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = x + x*i;
        }
                
        return arr;
    }
}