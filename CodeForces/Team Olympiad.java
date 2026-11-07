import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr= new int [n];
        int sum =0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }


        ArrayList<Integer> pr= new ArrayList<>();
        ArrayList<Integer> m= new ArrayList<>();
        ArrayList<Integer> pE= new ArrayList<>();
        for(int i=0; i<n; i++){
            if(arr[i]==1){
                pr.add(i+1);
            }
            else if(arr[i]==2){
                m.add(i+1);
            }else {
                pE.add(i+1);
            }
        }
        int team= Math.min(pr.size(),Math.min(m.size(),pE.size()));
        System.out.println(team);
        for(int i=0; i<team; i++){
            System.out.print(pr.get(i)+" "+m.get(i)+" "+pE.get(i));
            System.out.println( );
        }
    }
}
