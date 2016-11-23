/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydream;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Sanjay
 */
public class MyDream extends JFrame
{
    JLabel jl1,jl2;
    AnimationClass ac;
    ImageIcon im1,im2,im3,im4,im5,im6,im7,im;
    static Image img;
    public MyDream()
    {
        im1=new ImageIcon(getClass().getResource("/images/1dm.png"));
        im2=new ImageIcon(getClass().getResource("/images/2dm.png"));
        im3=new ImageIcon(getClass().getResource("/images/3dm.png"));
        im4=new ImageIcon(getClass().getResource("/images/4dm.png"));
        im5=new ImageIcon(getClass().getResource("/images/5dm.png"));
        im6=new ImageIcon(getClass().getResource("/images/6dm.png"));
        im7=new ImageIcon(getClass().getResource("/images/7dm.png"));
        jl1=new JLabel(im7);        
        add(jl1);
        jl2=new JLabel(im1);
        add(jl2);
        
        setLayout(null);
        im=new ImageIcon(getClass().getResource("/images/d.jpg"));
        img=im.getImage();
        //img=Toolkit.getDefaultToolkit().getImage(im.getImage());
        jl1.setBounds(0,0,630,390);
        jl2.setBounds(630,0,630,390);
       
        ac=new AnimationClass();
        slideView();
    }
    public void slideView()
    {
       new Thread()
       {
           int count=0;
           @Override
           public void run()
           {
               try
               {
                   while(true)
                   {
                       switch(count)
                       {
                           case 0:
                               Thread.sleep(4000);
                               jl1.setIcon(im7);
                               jl2.setIcon(im1);
                               ac.jLabelXLeft(0,-630,10,5, jl1);
                               ac.jLabelXLeft(630,0,10,5, jl2);
                               count=1;
                               break;
                           case 1:
                               Thread.sleep(4000);
                               jl1.setIcon(im2);
                               jl2.setIcon(im1);
                               ac.jLabelXRight(-630,0,10,5, jl1);
                               ac.jLabelXRight(0,630,10,5, jl2);
                               count=2;
                               break;
                          case 2:
                               Thread.sleep(4000);
                               jl1.setIcon(im2);
                               jl2.setIcon(im3);
                               ac.jLabelXLeft(0,-630,10,5, jl1);
                               ac.jLabelXLeft(630,0,10,5, jl2);
                               count=3;
                               break;
                          case 3:
                               Thread.sleep(4000);
                               jl1.setIcon(im6);
                               jl2.setIcon(im3);
                               ac.jLabelXRight(-630,0,10,5, jl1);
                               ac.jLabelXRight(0,630,10,5, jl2);
                               count=4;
                               break;  
                          case 4:
                               Thread.sleep(4000);
                               jl1.setIcon(im6);
                               jl2.setIcon(im4);
                               ac.jLabelXLeft(0,-630,10,5, jl1);
                               ac.jLabelXLeft(630,0,10,5, jl2);
                               count=5;
                               break;  
                          case 5:
                               Thread.sleep(4000);
                               jl1.setIcon(im5);
                               jl2.setIcon(im4);
                               ac.jLabelXRight(-630,0,10,5, jl1);
                               ac.jLabelXRight(0,630,10,5, jl2);
                               count=6;
                               break; 
                         case 6:
                               Thread.sleep(4000);
                               jl1.setIcon(im5);
                               jl2.setIcon(im7);
                               ac.jLabelXLeft(0,-630,10,5, jl1);
                               ac.jLabelXLeft(630,0,10,5, jl2);
                               count=0;
                               break;       
                       }
                   }
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
       }.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MyDream md=new MyDream();
                md.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                md.setIconImage(img);
                md.setTitle("My Dreams");
                md.setSize(630,390);
                md.setLocation(400,100);
                md.setVisible(true);
                md.setResizable(false);
                md.getContentPane().setBackground(Color.BLACK);
            }
        });
    }
    
}
