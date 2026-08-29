class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int c=0;
       for(int i=0; i<s.length(); i++){
        if(s.charAt(i)==' '){
            c++;
            if(c==k){
                break;
            }
        }
        sb.append(s.charAt(i));
       }
      return sb.toString();
    }
}