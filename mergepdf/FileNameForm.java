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

class FileNameForm extends JFrame implements ActionListener{
  JLabel label;
  JTextField text;

  public static void main(String args[]){
    
    FileNameForm frame = new FileNameForm("MyTitle");
    frame.setVisible(true);
  }

  FileNameForm(String title){
    setTitle(title);
    setBounds(100, 100, 500, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    text = new JTextField(20);
    JButton button = new JButton("Get");
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
  }
}
