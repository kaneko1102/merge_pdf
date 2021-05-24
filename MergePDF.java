// ref: https://dolphinpg.net/program/java-pdfbox-merge/

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
    public static void mergePDF(ArrayList<String> pdfFiles,String merge_filename) {
     
        List<InputStream> sources = new ArrayList<InputStream>();
        // ディレクトリにあるPDFファイルを一つずつ読み込む
        try{
            for(int i = 0; i < pdfFiles.size(); i++){
                InputStream is = new FileInputStream(pdfFiles.get(i));
                sources.add(is);
            }
            FileOutputStream mergedPDFOutputStream =  new FileOutputStream(merge_filename);
    
            PDFMergerUtility pdfMerger = new PDFMergerUtility();
            pdfMerger.addSources(sources);
            pdfMerger.setDestinationStream(mergedPDFOutputStream);
         
            //PDFのMerge出力
            pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
 
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    // ref: https://qiita.com/tedkuma/items/4d0f66443b1cefdd2392
    public static void mergePDFExec(String dirName,String output_file) {
        ArrayList<String> pdfFiles = new ArrayList<String>();
        File dir = new File(dirName);
        File[] list = dir.listFiles();
        // ディレクトリにあるpdfファイルのファイル名を取得
        for(int i = 0; i < list.length; i++) {
            if(list[i].getName().contains(".pdf")) {
                pdfFiles.add(dirName+"/"+list[i].getName());
            }
        }
        // ファイル名を辞書順に並び替え
        Collections.sort(pdfFiles);

        mergePDF(pdfFiles,output_file);
    }
}
