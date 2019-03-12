package Futam.Menu;

import Futam.Jatek.Grafika.Render;
import Futam.Ranglista.Ranglista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by bartf on 2016. 11. 24..
 */
public class Hatter{

    private static Image start, highscores, option, exit;
    public static Render render;

        public Hatter(){
            try {

            File input=new File("Kepek/startgomb.bmp");
            start = ImageIO.read(input);

            input=new File("Kepek/highscoregomb.bmp");
            highscores = ImageIO.read(input);

            input=new File("Kepek/exitgomb.bmp");
            exit = ImageIO.read(input);

            input=new File("Kepek/optiongomb.bmp");
            option = ImageIO.read(input);

            } catch (IOException ex) {
                System.err.println(ex);
            }

            render = new Render();
            Render.kep.add(render);

            Render.kep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Render.kep.setSize(806, 635);
            Render.kep.setVisible(true);
            Render.kep.setResizable(false);
            Render.kep.addMouseListener(new Futam.Menu.Menu());
            Ranglista.Beolvas();

        }

        public static void kirajzol(Graphics g){
            g.setColor(Color.orange);
            g.fillRect(0,0,800,600);



                g.drawImage(start,277,100,null);
                g.drawImage(highscores,327,260,null);
                g.drawImage(option,327,360,null);
                g.drawImage(exit,327,460,null);
        }
    }
