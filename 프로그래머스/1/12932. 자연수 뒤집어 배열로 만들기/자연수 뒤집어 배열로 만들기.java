class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        
        int[] nums = new int[str.length()];
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int)(n % 10);
            n /= 10;
            
        }        
        return nums;
    }
}