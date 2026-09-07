class Solution {
    public int characterReplacement(String s, int k) {
      int []feq= new int [26];
      int max=0,maxfeq=0;
      int left=0;
      int n = s.length();
      for(int right =0; right<n; right++){
        int index=s.charAt(right)-'A';
        feq[index]++;
        maxfeq=Math.max(maxfeq, feq[index]);
        int windowsize=right-left+1;
        int replace = windowsize-maxfeq;
  if(replace>k){
            feq[s.charAt(left)-'A']--;
            left++;
        }
      
    max=Math.max(max, right-left+1);
      }
      return max;
    }
}