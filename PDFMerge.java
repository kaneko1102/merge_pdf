// https://dolphinpg.net/program/java-pdfbox-merge/
//コンパイルコマンド javac -classpath .:pdfbox-app-3.0.0-RC1.jar PDFMerge.java
//実行コマンド java -classpath .:pdfbox-app-3.0.0-RC1.jar PDFMerge
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
 
public class PDFMerge {
  public static void main(String[] arg) {
       
    //Merge対象の2ファイル
    File file_first = new File("img001.pdf");
    File file_second = new File("img002.pdf");
     
    //Merge後のファイル名
    String merge_filename = "output.pdf";
     
    List<InputStream> sources = new ArrayList<InputStream>();
     
    try(InputStream is0 = new FileInputStream(file_first);
      InputStream is1 = new FileInputStream(file_second);
      FileOutputStream mergedPDFOutputStream =  new FileOutputStream(merge_filename)) {
       
      sources.add(is0);
      sources.add(is1);
       
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
