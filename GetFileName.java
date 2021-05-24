// https://qiita.com/tedkuma/items/4d0f66443b1cefdd2392
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class GetFileName {

    public static void getFileName(String dirName) {
        ArrayList<String> pdfFiles = new ArrayList<String>();
        File dir = new File(dirName);
        File[] list = dir.listFiles();
        for(int i = 0; i < list.length; i++) {
            if(list[i].getName().contains(".pdf")) {
                pdfFiles.add(list[i].getName());
            }
        }
        Collections.sort(pdfFiles);
        for(int i = 0; i < pdfFiles.size(); i++){
            System.out.println(pdfFiles.get(i));
        }
    }
}
