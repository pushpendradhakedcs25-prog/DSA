class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length-1;
        int re[]= new int [nums.length];
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            if(Math.abs(nums[start])>Math.abs(nums[end])){
              re[n]=nums[start]*nums[start];
              n--;
              start++;
            }
            else{
              re[n]=nums[end]*nums[end];
              n--;
              end--;
            }
        }
        return re;
    }
}
