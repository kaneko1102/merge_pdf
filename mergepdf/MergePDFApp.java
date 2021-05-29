package mergepdf;
// https://www.javadrive.jp/tutorial/jfilechooser/index9.html
//コンパイルコマンド javac -classpath .:pdfbox-app-3.0.0-RC1.jar mergepdf/MergePDFApp.java
//実行コマンド java -classpath .:pdfbox-app-3.0.0-RC1.jar mergepdf.MergePDFApp
import javax.swing.*;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.event.*;

public class MergePDFApp extends JFrame implements ActionListener{
//public class MergePDFApp extends FileNameForm{
  JLabel label;
  JButton button;// = new JButton("folder select");
  JButton execButton;// = new JButton("exec");
  String dir;
  JTextField inputDirText;

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

    button = new JButton("folder select");
    button.addActionListener(this);

    execButton = new JButton("exec");
    execButton.addActionListener(this);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(button);

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
    if(obj == button){
      JFileChooser filechooser = new JFileChooser();
      filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      //filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      File file;
      //int selected = filechooser.showSaveDialog(this);
      int selected = filechooser.showOpenDialog(this);
    
      //String cmd = e.getActionCommand();
    
      if (selected == JFileChooser.APPROVE_OPTION){
        file = filechooser.getSelectedFile();
        dir = file.getAbsolutePath();
        //label.setText(dir);
        inputDirText.setText(dir);
        //MergePDF.mergePDFExec(file.getAbsolutePath(),"output.pdf");
      }
    }
    if(obj == execButton){
      //label.setText("実行"+dir);
      System.out.println(dir);
      MergePDFOutput frame = new MergePDFOutput("test");
      frame.setVisible(true);
      //MergePDF.mergePDFExec(dir,"output.pdf");
    }
  }
}
