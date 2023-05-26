package Swing.Hello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hello implements ActionListener {
    JFrame frame;
    JButton button;

    public void go(){
        frame = new JFrame("Чето я всё забыл");

        Image iconImage = new ImageIcon("D:\\МОЯ ПАПКА\\МОИ САЙТЫ\\agorohov\\Логотип\\logo 90x90.png").getImage();
        frame.setIconImage(iconImage);

        button = new JButton("Тычни сюдой");
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.getContentPane().add(BorderLayout.CENTER, new Grafikka());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new Hello().go();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("HELLO!");
    }

    class Grafikka extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            g.setColor(Color.red);
            g.fillOval(50, 50, 70, 90);
        }
    }
}