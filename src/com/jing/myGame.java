package com.jing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class myGame extends JFrame
{
    MyPanel mp = null;

    public static void main(String[] args)
    {
        myGame mg = new myGame();
    }
    public myGame()
    {
        mp = new MyPanel();
        this.setLayout(new GridLayout(1,1));
        this.add(mp);

        //监听
        this.addKeyListener(mp);
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
class MyPanel extends JPanel implements KeyListener
{
    int x=0,y=330;
    //画笔

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x,y,30,30);
    }
    public void keyPressed(KeyEvent arg0)
    {
        if(arg0.getKeyCode()==KeyEvent.VK_UP)
        {
            y-=10;
            if(y<0)
            {

                y+=10;
            }

        }
        if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
        {
            y+=10;
            if((y+30)>getHeight())
            {

                y-=10;
            }
        }
        if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            x+=10;
            if((x+30)>getWidth())
            {

                x-=10;
            }

        }
        if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
        {
            x-=10;
            if(x<0)
            {

                x+=10;
            }
        }
        this.repaint();
    }
    public void keyReleased(KeyEvent arg0)
    {

    }
    public void keyTyped(KeyEvent arg0)
    {

    }
}
