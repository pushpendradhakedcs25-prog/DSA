class Solution {
    public int minInsertions(String s) {
        int i=0; 
        int count=0;
        int result =0; 
        int n = s.length();
            while(i<n){
                if(s.charAt(i)=='('){
                    i++;
                    count++;
                }else{
                    // left sie check of ")"

                    //Is "("
                    if(count>0){
                        count--;
                    }
                    //Is not "("
                    else{
                        result++;
                    }

                    if(i+1<n && s.charAt(i+1)==')'){
                        i+=2;
                    }else{
                        result++;
                        i++;
                    }
                }
            }

        return result +2*count ;
    }
}
