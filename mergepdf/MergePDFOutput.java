package mergepdf;
// https://www.javadrive.jp/tutorial/jtextfield/index9.html
// https://www.javadrive.jp/tutorial/jfilechooser/index3.html
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.File;

class MergePDFOutput extends JFrame implements ActionListener{
  JLabel label;
  JTextField outputDirText;
  String outputFile;
  JButton selectFolderButton;
  //String getOutputDir;

  MergePDFOutput(String title, String dir){
    setTitle(title);
    setBounds(100, 100, 500, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    outputDirText = new JTextField(20);
    outputDirText.setText(dir);
    selectFolderButton = new JButton("フォルダを選択");
    selectFolderButton.addActionListener(this);

    JPanel p = new JPanel();
    p.add(outputDirText);
    p.add(selectFolderButton);

    label = new JLabel();

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
    contentPane.add(label, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();
    if(obj == selectFolderButton){
      JFileChooser filechooser = new JFileChooser();
      //filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int selected = filechooser.showSaveDialog(this);
      File file;
      if (selected == JFileChooser.APPROVE_OPTION){
        file = filechooser.getSelectedFile();
        //getOutputDir = file.getAbsolutePath();
        outputDirText.setText(file.getAbsolutePath());
      }
    }
    //label.setText(outputDirText.getText());
    //outputFile = outputDirText.getText();

    //text.setText(outputFile);
    //JFileChooser filechooser = new JFileChooser();
    //filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    //File file;
    //int selected = filechooser.showSaveDialog(this);
  }
}
