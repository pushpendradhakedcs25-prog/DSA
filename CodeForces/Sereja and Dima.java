import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr= new int[n];
        for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

       int start =0;
    int end = arr.length-1;
    boolean t=true;
    int s=0;
    int d=0;
    while(start<=end){
        int pick;
    if(arr[start]<arr[end]){

        pick=arr[end];
        end--;
    }else{

        pick=arr[start];
        start++;
    }
    if(t){
       s+=pick;
    }else{
        d+=pick;
    }
    t=!t;
    }
        System.out.println(s+" "+d);
    }
}
