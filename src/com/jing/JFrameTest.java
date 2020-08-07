package com.jing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JFrameTest extends JFrame
{
    TestPane tp = null;

    public static void main(String[] args)
    {
        new JFrameTest();

    }
    public JFrameTest()
    {

        tp = new TestPane();
        this.add(tp);
        this.addKeyListener(tp);

        this.setSize(300,400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // this.pack();
        this.setVisible(true);
    }
    class TestPane extends JPanel implements KeyListener
    {
        int x,y;
        int x1 = 0;
        int y1 = 0;
        int m=1;



        public TestPane()
        {
            Timer timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x+=m;
                    if((x+30)>getWidth())
                    {
                        x = getWidth() - 30;
                        m *= -1;
                    } else if(x<0)
                    {
                        x=0;
                        m *= -1;
                    }
                    ballCollide();


                    repaint();

                }
            });
            timer.start();
        }



        @Override
        public void paint(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;
            super.paint(g);
            super.paint(g2d);
            g.setColor(Color.RED);
            g.fillOval(x,y,30,30);
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x1,y1,30,30);

    }
        public void keyPressed(KeyEvent arg0)
        {

            if(arg0.getKeyCode()==KeyEvent.VK_UP)
            {
                y1-=10;
                if(y1<0)
                {
                    y1+=10;
                }

            }
            if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
            {
                y1+=10;
                if((y1+30)>getHeight())
                {
                    y1-=10;
                }
            }
            if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                x1+=10;
                if((x1+30)>getWidth())
                {

                    x1-=10;
                }

            }
            if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
            {
                x1-=10;
                if(x1<0)
                {

                    x1+=10;
                }
            }



            this.repaint();

        }
        public void ballCollide()
        {
            int subX = x1-x;
            int subY = y1-y;

            if(Math.sqrt(Math.pow(subX,2)+Math.pow(subY,2))<30)
            {

                y1+=30;
                System.out.println("碰撞啦！");
            }

        }
        public void keyReleased(KeyEvent arg0)
        {

        }
        public void keyTyped(KeyEvent arg0)
        {

        }

    }

    }
