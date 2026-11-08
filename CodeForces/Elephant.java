import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int x = sc.nextInt();
       int count =x/5;
       if(x%5!=0){
           count++;
       }

        System.out.println(count);
    }
}
