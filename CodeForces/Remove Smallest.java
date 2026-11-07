import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         for(int i=0; i<n; i++){
             int t=sc.nextInt();
             int []arr= new int [t];
             for(int j=0; j<t; j++){
                 arr[j]=sc.nextInt();
             }
             Arrays.sort(arr);
              boolean check=true;
             for(int j=0; j<t-1; j++){
                 if(Math.abs(arr[j]-arr[j+1])>1){
                      check=false;
                 }
             }
             if(check){
                 System.out.println("Yes");
             }else{
                 System.out.println("No");
             }


         }
    }
}
