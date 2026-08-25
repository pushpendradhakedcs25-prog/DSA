class Solution {
    public int myAtoi(String s) {
        
       int i=0;
       int n = s.length();
       int max = Integer.MAX_VALUE;
       int min = Integer.MIN_VALUE;
       while(i<n && s.charAt(i)==' '){
        i++;
       }
     
       int sign =1;
       if(i<n&&s.charAt(i)=='+') i++;
       else if(i<n&&s.charAt(i)=='-'){
        i++;
        sign=-1;
       }
       long rev=0;
       while(i<n && Character.isDigit(s.charAt(i))){
           rev = rev*10+  s.charAt(i)-'0';
           if(rev*sign <=  min){
            return min;
           }
           if(rev*sign>=max){
            return max;
           }
           i++;
       }
       return (int)(sign * rev);
    }
}