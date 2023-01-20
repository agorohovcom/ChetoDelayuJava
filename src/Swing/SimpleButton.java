package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleButton implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        new SimpleButton().go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Нажми сюда =)");

        button.addActionListener(this);

        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Охххх, меня нажаллли!");
    }
}
