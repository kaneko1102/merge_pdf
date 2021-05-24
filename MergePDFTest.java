import java.util.Scanner;

public class MergePDFTest extends MergePDF{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dirName = sc.next();
        mergePDFExec(dirName);
        sc.close();
    } 
}
