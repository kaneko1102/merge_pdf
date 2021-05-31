package mergepdf;
// https://www.javadrive.jp/tutorial/jfilechooser/index9.html
//コンパイルコマンド javac -classpath .:pdfbox-app-3.0.0-RC1.jar mergepdf/MergePDFApp.java
//実行コマンド java -classpath .:pdfbox-app-3.0.0-RC1.jar mergepdf.MergePDFApp
import javax.swing.*;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.event.*;

public class MergePDFApp extends JFrame implements ActionListener{
  JLabel label;
  JButton selectButton; // フォルダ選択のボタン
  JButton execButton; // 実行ボタン
  String dir; //読み込むディレクトリ
  JTextField inputDirText; //読み込むディレクトリのテキストフィールド

  public static void main(String[] args){
    MergePDFApp frame = new MergePDFApp();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 600, 200);
    frame.setTitle("Merge PDF");
    frame.setVisible(true);
  }

  MergePDFApp(){
    inputDirText = new JTextField(38);
    JPanel dirText = new JPanel();
    dirText.add(inputDirText);

    selectButton = new JButton("フォルダを選択");
    selectButton.addActionListener(this);

    execButton = new JButton("実行");
    execButton.addActionListener(this);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(selectButton);

    JPanel execButtonPanel = new JPanel();
    execButtonPanel.add(execButton);

    label = new JLabel();

    JPanel labelPanel = new JPanel();
    labelPanel.add(label);

    getContentPane().add(labelPanel, BorderLayout.CENTER);
    getContentPane().add(buttonPanel, BorderLayout.LINE_END);
    getContentPane().add(execButtonPanel, BorderLayout.PAGE_END);
    getContentPane().add(dirText, BorderLayout.LINE_START);
  }
  //ボタンを押した時に実行
  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();
    // フォルダ選択ボタンを押したとき
    if(obj == selectButton){
      JFileChooser filechooser = new JFileChooser();
      filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      File file;
      int selected = filechooser.showOpenDialog(this);
    
      if (selected == JFileChooser.APPROVE_OPTION){
        file = filechooser.getSelectedFile();
        dir = file.getAbsolutePath();
        inputDirText.setText(dir);
      }
    }
    // 実行ボタンを押したとき
    if(obj == execButton){
      dir = inputDirText.getText();
      JFileChooser saveFilechooser = new JFileChooser(dir);
      int selected = saveFilechooser.showSaveDialog(this);
      File file;
      if (selected == JFileChooser.APPROVE_OPTION){
        file = saveFilechooser.getSelectedFile();
        String outputPDFFile = file.getAbsolutePath();
        //MergePDF.mergePDFExec(dir,outputPDFFile); // pdfを結合
        System.out.println(dir);
        JOptionPane.showMessageDialog(this, "完了");
      }
    }
  }
}
