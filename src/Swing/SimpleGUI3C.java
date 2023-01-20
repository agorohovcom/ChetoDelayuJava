package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI3C implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        new SimpleGUI3C().go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JButton button = new JButton("ПЕРЕКРАСИТЬ!");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g){
//        g.setColor(Color.red);
//        g.fillRect(20, 50, 100, 100);

//        Image image = new ImageIcon("D:\\Wallpapers\\23xgmgrnxc031.jpg").getImage();
//        g.drawImage(image, 3, 4, this);

//        g.fillRect(0, 0, this.getWidth(), this.getHeight());
//        int red = (int) (Math.random() * 255);
//        int green = (int) (Math.random() * 255);
//        int blue = (int) (Math.random() * 255);
//        Color randomColor = new Color(red, green, blue);
//        g.setColor(randomColor);
//        g.fillOval(70, 70, 100, 100);

        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);

        g2d.setPaint(gradient);
        g2d.fillOval(50, 20, 180, 180);
    }
}
