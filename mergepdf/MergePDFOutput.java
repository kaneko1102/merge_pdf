package mergepdf;
// https://www.javadrive.jp/tutorial/jtextfield/index9.html
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
  JTextField text;
  String outputFile;
  //public static void main(String args[]){
    
  //  FileNameForm frame = new FileNameForm("MyTitle");
  //  frame.setVisible(true);
  //}

  MergePDFOutput(String title){
    setTitle(title);
    setBounds(100, 100, 500, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    text = new JTextField(20);
    JButton button = new JButton("output");
    button.addActionListener(this);

    JPanel p = new JPanel();
    p.add(text);
    p.add(button);

    label = new JLabel();

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
    contentPane.add(label, BorderLayout.SOUTH);
    
  }

  public void actionPerformed(ActionEvent e){
    label.setText(text.getText());
    outputFile = text.getText();
    text.setText(outputFile);
    //JFileChooser filechooser = new JFileChooser();
    //filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    //File file;
    //int selected = filechooser.showSaveDialog(this);
  }
}
