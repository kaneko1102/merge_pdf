package mergepdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
 
// download from https://www.apache.org/dyn/closer.lua/pdfbox/3.0.0-RC1/pdfbox-app-3.0.0-RC1.jar
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class MergePDF{
  // pdfFilesに格納されているファイル名のpdfファイルを結合し、ファイル名をmergeFileNameで指定した名前で出力
  // 参考: https://dolphinpg.net/program/java-pdfbox-merge/
  public static void mergePDF(ArrayList<String> pdfFiles,String mergeFileName) {   
    List<InputStream> pdfSources = new ArrayList<InputStream>();
    
    try{
      // ディレクトリにあるPDFファイルを一つずつ読み込む
      for(int i = 0; i < pdfFiles.size(); i++){
        InputStream is = new FileInputStream(pdfFiles.get(i));
        pdfSources.add(is);
      }
      FileOutputStream mergedPDFOutputStream =  new FileOutputStream(mergeFileName);
    
      PDFMergerUtility pdfMerger = new PDFMergerUtility();
      pdfMerger.addSources(pdfSources);
      pdfMerger.setDestinationStream(mergedPDFOutputStream);
      //PDFをMergeして出力
      pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }
  // inputDirNameで指定したディレクトリにあるpdfファイルのファイル名を取得しoutputFileで指定したファイル名で出力
  //参考: https://qiita.com/tedkuma/items/4d0f66443b1cefdd2392
  public static void mergePDFExec(String inputDirName,String outputFile) {
    ArrayList<String> pdfFiles = new ArrayList<String>();
    inputDirName = inputDirName.replace("\\","/");
    File inputDir = new File(inputDirName);
    
    File[] dirFiles = inputDir.listFiles();
    // ディレクトリにあるpdfファイルのファイル名を取得
    for(int i = 0; i < dirFiles.length; i++) {
      if(dirFiles[i].getName().contains(".pdf")||dirFiles[i].getName().contains(".PDF")) {
        
        pdfFiles.add(inputDirName+"/"+dirFiles[i].getName());
      }
    }
    // ファイル名を辞書順に並び替え
    Collections.sort(pdfFiles);
    // ファイル結合
    mergePDF(pdfFiles,outputFile);
  }
}
