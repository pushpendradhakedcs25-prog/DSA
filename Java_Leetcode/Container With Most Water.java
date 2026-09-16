class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxAra=0;
        while(left<right){
            int W=right-left;
            int H=Math.min(height[right],height[left]);
            maxAra=Math.max(maxAra,W*H);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxAra;
    }
}
