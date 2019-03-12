package Futam.Nev;

/**
 * Created by bartf on 2016. 11. 27..
 */

import Futam.Jatek.Grafika.Render;

import javax.swing.*;
import java.awt.*;


public class Hatter{


    public static String name="";

    public static Render render;
    public static Nev Listener = new Nev();

    public Hatter(){
        render = new Render();
        Render.kep.add(render);

        Render.kep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Render.kep.setSize(806, 635);
        Render.kep.setVisible(true);
        Render.kep.setResizable(false);
        Render.kep.addMouseListener(Listener);
        Render.kep.addKeyListener(Listener);
    }

    public static void kirajzol(Graphics g){
        Font font;
        font=new Font("Arial",1,100);
        FontMetrics metrics = g.getFontMetrics(font);
        g.setColor(Color.orange);
        g.fillRect(0,0,800,600);

        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Options",400-metrics.stringWidth("OPtions")/2,80);


        g.setColor(Color.black  );
        g.fillRect(50,240,700,120);

        g.fillRect(325,550,150,50);//BACK gomb kezd
        g.setColor(Color.orange);
        font=new Font("Arial",1,25);
        metrics = g.getFontMetrics(font);
        g.setFont(font);
        g.drawString("BACK", 400 - metrics.stringWidth("BACK")/2,585); //BACK gomb veg

        g.setColor(Color.black); // RESET gomb
        g.fillRect(140,400,520,60);
        g.setColor(Color.orange);
        font=new Font("Arial",1,50);
        metrics = g.getFontMetrics(font);
        g.setFont(font);
        g.drawString("RESET HIGHSCORES", 400 - metrics.stringWidth("RESET HIGHSCORES")/2,450); //RESET gomb



        font=new Font("Arial",1,70);
        g.setFont(font);
        g.drawString("NAME:", 55,325);
        g.drawRect(290,250,450,100);
        g.drawString(name, 295,325);
    }
}
