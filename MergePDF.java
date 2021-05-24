// ref: https://dolphinpg.net/program/java-pdfbox-merge/
//コンパイルコマンド javac -classpath .:pdfbox-app-3.0.0-RC1.jar MergePDF.java
//実行コマンド java -classpath .:pdfbox-app-3.0.0-RC1.jar MergePDF
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
// https://www.apache.org/dyn/closer.lua/pdfbox/3.0.0-RC1/pdfbox-app-3.0.0-RC1.jar
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
 
public class MergePDF{
    public static void mergePDF(ArrayList<String> pdfFiles) {
       
        //Merge対象の2ファイル
        //File file_first = new File("img001.pdf");
        //File file_second = new File("img002.pdf");
     
        //Merge後のファイル名
        String merge_filename = "output.pdf";
     
        List<InputStream> sources = new ArrayList<InputStream>();
        //InputStream[] is = new InputStream[pdfFiles.size()];
     
        try{
            for(int i = 0; i < pdfFiles.size(); i++){
                InputStream is = new FileInputStream(pdfFiles.get(i));
                sources.add(is);
            }
            FileOutputStream mergedPDFOutputStream =  new FileOutputStream(merge_filename);
            /*
            for(int i = 0; i < pdfFiles.size(); i++){
                 sources.add(is);
            }
            */
            //sources.add(is1);
    
            PDFMergerUtility pdfMerger = new PDFMergerUtility();
            pdfMerger.addSources(sources);
            pdfMerger.setDestinationStream(mergedPDFOutputStream);
         
            //PDFのMerge出力
            pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
 
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
