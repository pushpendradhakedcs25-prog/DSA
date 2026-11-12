class Solution {
    int  max1=0,max2=0;
    public void  increAndDecre(int []arr){
      
      if(arr.length==1){
        max1=1;
        return ;
      }
        int i=0;
        int j=1;
        while(j<arr.length){
            
                if(arr[j-1]<arr[j]){
                   j++;
                }else{
                    i=j;
                    j++;
                }
        max2=Math.max(j-i, max2);
        }
        
            i=0;
         j=1;
        while(j<arr.length){
            
                if(arr[j-1]>arr[j]){
                   j++;
                }else{
                    i=j;
                    j++;
                }
        max2=Math.max(j-i, max2);
        }
    }
    public int longestMonotonicSubarray(int[] nums) {
       
        increAndDecre(nums);
        int max=Math.max(max1,max2);
        return max;
    }
}
