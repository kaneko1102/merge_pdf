//コンパイルコマンド javac -classpath .:pdfbox-app-3.0.0-RC1.jar MergePDFTest.java
//実行コマンド java -classpath .:pdfbox-app-3.0.0-RC1.jar MergePDFTest

import java.util.Scanner;

public class MergePDFTest extends MergePDF{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dirName = sc.next();
        mergePDFExec(dirName);
        sc.close();
    } 
}
