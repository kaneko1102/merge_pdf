// https://www.javadrive.jp/tutorial/jfilechooser/index9.html
import javax.swing.*;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.event.*;

public class MergePDFApp extends JFrame implements ActionListener{

  JLabel label;

  public static void main(String[] args){
    MergePDFApp frame = new MergePDFApp();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  MergePDFApp(){
    JButton button = new JButton("file select");
    button.addActionListener(this);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(button);

    label = new JLabel();

    JPanel labelPanel = new JPanel();
    labelPanel.add(label);

    getContentPane().add(labelPanel, BorderLayout.CENTER);
    getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
  }

  public void actionPerformed(ActionEvent e){
    JFileChooser filechooser = new JFileChooser("/Users/kanekotakuya");
    filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int selected = filechooser.showSaveDialog(this);
    if (selected == JFileChooser.APPROVE_OPTION){
      File file = filechooser.getSelectedFile();
      label.setText(file.getAbsolutePath());
      MergePDF.mergePDFExec(file.getAbsolutePath(),"output.pdf");
    }
  }
}
