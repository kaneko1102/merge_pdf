import java.util.Scanner;

public class GetFileNameTest extends GetFileName{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dirName = sc.next();
        getFileName(dirName);
        sc.close();
    } 
}
