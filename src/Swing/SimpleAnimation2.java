package Swing;

import Patterns.Singleton.MySingleton;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation2 {
    int x = 1;
    int y = 1;

    public static void main(String[] args) {
        new SimpleAnimation2().go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(500,270);

        MyDrawP drawP = new MyDrawP();
        frame.getContentPane().add(drawP);

        for(int i = 0; i < 124; i++,x++,y++){
            x++;
            drawP.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class MyDrawP extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,500,250);
            g.setColor(Color.blue);
            g.fillRect(x,y,500-x*2,250-y*2);
        }
    }
}
