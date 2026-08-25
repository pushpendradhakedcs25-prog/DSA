lass Solution {
    public String reverseWords(String s) {
        //interviw Q
       String []arr = s.trim().split("\\s+");  
       // s->["hello","world"],["a","good","example"]
          
          StringBuilder sb = new StringBuilder();
          for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);  //["world","hello"]  , ["example","good","a"]
            if(i!=0){
            sb.append(" ");//["world"," ",hello"] , ["example"," ","good"," ","a"]
            }
          }
          return sb.toString();
    }
}