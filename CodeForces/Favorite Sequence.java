import java.util.Scanner;
public class Main{
 public static void main (String args []){
 Scanner sc= new Scanner (System.in);
int a=sc.nextInt();
 
 
for(int i=0; i<a; i++){
int n=sc.nextInt();
int arr[] = new int[n];
 for(int j=0; j<n; j++){
     arr[j]=sc.nextInt();}
int start=0; 
int end=arr.length-1;
int k=0;
int P[]= new int [n];
Boolean t=false;
while(start<=end){
if(!t){
   P[k]=arr[start];
k++;
t=true;
start++;}
else{
P[k]=arr[end];
k++;
t=false;
end--;}
   }
for(int l=0; l<n; l++){
        System.out.print(P[l]+" ");}
   System.out.println();
}
}
}
