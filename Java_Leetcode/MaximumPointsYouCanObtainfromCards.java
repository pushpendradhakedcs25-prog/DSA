class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n= cardPoints.length;
        int sum =0;
        for(int i=0; i<k; i++){
            sum+=cardPoints[i];
        }
        int max=sum;
        int left =k-1;
        for(int j=n-1; j>=n-k; j--){
            sum+=cardPoints[j];
            sum-=cardPoints[left];
            left--;
            max=Math.max(sum,max);
        }
       
        return max;
    }
}
