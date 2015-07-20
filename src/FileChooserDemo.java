import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
// 菜单按钮输出文件保存路径
public class FileChooserDemo {

    private JFileChooser chooser = new JFileChooser();
    private JButton saveButton = new JButton("Save");
    private JLabel label = new JLabel("  ");

    public FileChooserDemo() {
        JFrame frame = new JFrame("JFileChooser Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//选择目录，选择文件的话注释掉这行。

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int retValue = chooser.showSaveDialog(saveButton);
                if (retValue == JFileChooser.APPROVE_OPTION) {
                    label.setText(chooser.getSelectedFile().toString());
                }
            }
        });

        frame.getContentPane().add(saveButton, BorderLayout.CENTER);
        frame.getContentPane().add(label, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(200, 100));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileChooserDemo();
            }
        });
    }
}