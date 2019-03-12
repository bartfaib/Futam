package Futam.Ranglista;

import Futam.Jatek.Grafika.Render;

import javax.swing.*;
import java.awt.*;


/**
 * Created by bartf on 2016. 11. 24..
 */
public class Hatter{

    public static Render render;

    public Hatter(){
        render = new Render();
        Render.kep.add(render);
        Render.kep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Render.kep.setSize(806, 635);
        Render.kep.setVisible(true);
        Render.kep.setResizable(false);
        Render.kep.addMouseListener(new Ranglista());
    }

    public static void kirajzol(Graphics g){
        Font font;
        font=new Font("Arial",1,100);
        FontMetrics metrics = g.getFontMetrics(font);
        g.setColor(Color.orange);
        g.fillRect(0,0,800,600);

        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Highscores",400-metrics.stringWidth("Highscores")/2,80);


        g.setColor(Color.black  );
        g.fillRect(325,550,150,50);//BACK gomb
        g.fillRect(200,120,400,400);
        g.setColor(Color.orange);
        g.fillRect(200,153,400,5);



        font=new Font("Arial",1,25);
        metrics = g.getFontMetrics(font);
        g.setFont(font);

        g.drawString("BACK", 400 - metrics.stringWidth("BACK")/2,585);

        String text="NAME";
        g.drawString(text, 400 - metrics.stringWidth(text)/2,145);
        text ="SCORE";
        g.drawString(text, 590 - metrics.stringWidth(text),145);

        if(!Ranglista.VList.isEmpty())
        for(int i=0;i<Ranglista.VList.size(); i++) {
            text =Integer.toString(i+1)+".";
            g.drawString(text, 210,180+i*35);
            text=Ranglista.VList.get(i).getName();
            g.drawString(text, 400 - metrics.stringWidth(text)/2,180+i*35);
            text =Ranglista.VList.get(i).getPont();
            g.drawString(text, 590 - metrics.stringWidth(text),180+i*35);
            if(i==9)
                break;
        }

    }
}
