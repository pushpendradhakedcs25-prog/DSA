package Java_Primative_DataType.Static;

public class Main{
    public static void main(String[] args) {

      
        StaticKeywords s1  = new StaticKeywords("Rahul");
        
        System.out.println("Number of student  is : " + StaticKeywords.count);
        System.out.println("Studnet Name is : "+s1.name);
    }
}