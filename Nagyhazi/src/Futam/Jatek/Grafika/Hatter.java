package Futam.Jatek.Grafika;


import Futam.Jatek.Vezerles.Vezerles;
import Futam.Ranglista.Ranglista;
import Futam.Ranglista.Versenyzok;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Hatter{
    private static int xszel = 800;
    public static int ymag = 635;

    public static int xcord=100, ycord=390;
    public static int clock=0;
    private static Random n = new Random();
    private static int rand1=n.nextInt(4);

    private static Random m = new Random();
    private static int rand2=m.nextInt(4);

    private static Vezerles vezerl = new Vezerles();
    public static Timer timer = new Timer(15,vezerl);
    private static Image hatter, kocka, fold;
    private static Image[] figura=new Image[3];

    public static Render render= Futam.Menu.Hatter.render;
    public static boolean jumped=false, up=true;
    public static int pont=0;


    public Hatter(){
        try {

            File input=new File("Kepek/hatter.png");
            hatter = ImageIO.read(input);

            input=new File("Kepek/kocka.png");
            kocka = ImageIO.read(input);



            input=new File("Kepek/fold.png");
            fold = ImageIO.read(input);

            input=new File("Kepek/stickman1.png");
            figura[0] = ImageIO.read(input);
            input=new File("Kepek/stickman2.png");
            figura[1] = ImageIO.read(input);
            input=new File("Kepek/stickman3.png");
            figura[2] = ImageIO.read(input);

        } catch (IOException ex) {
            System.err.println(ex);
        }


        //render= new Render();
        Render.kep.add(render);

        Render.kep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Render.kep.setSize(xszel, ymag);
        Render.kep.setVisible(true);
        Render.kep.setResizable(false);
        Render.kep.addMouseListener(vezerl);
        Render.kep.addKeyListener(vezerl);
        timer.start();

    }

    public static void jump(){
        if(jumped){
            if(ycord>=70&&up)
                ycord-=10;
            if(ycord<100)
                up=false;
            if(!up)
                ycord+=10;
            if(ycord>=390&&!up) {
                up = true;
                jumped=false;
            }
        }
    }

    public static boolean gameover(int magassag){
        boolean gameover=false;
        if(ycord>(400-(magassag*80)))
                gameover=true;
        if(gameover==false)
            pont++;
        return gameover;
    }

    public static int ertekszamol(int mod1, int mod2){
        int a=xszel+mod1;
        int ertek=0;
        if(clock/mod2>=a)
            ertek = a-Math.abs((a - clock/mod2) % a)-mod1;
        if(clock/mod2<a)
            ertek = Math.abs((a - clock/mod2) % a)-mod1;
        return ertek;
    }

    public static void GameOver(Graphics g){

        try {
            String name;
            BufferedReader br = new BufferedReader(new FileReader("name"));
            name = br.readLine();


        Ranglista.VList.add(Ranglista.VList.size(),new Versenyzok(name,Integer.toString(pont)));
        } catch (IOException e) {System.err.println(e);}
        Ranglista.rendez();

        Color c = new Color(255,155,0,220);
        g.setColor(c);

        g.fillRect(0,0,800,600);//BACK gomb kezd


        g.setColor(Color.black);//BACK gomb kezd
        g.fillRect(325,550,150,50);
        g.setColor(Color.orange);
        Font font=new Font("Arial",1,25);
        FontMetrics metrics;
        metrics = g.getFontMetrics(font);
        g.setFont(font);
        g.drawString("BACK", 400 - metrics.stringWidth("BACK")/2,585); //BACK gomb veg

        g.setColor(Color.black);

        font=new Font("Arial",1,100);
        g.setFont(font);
        metrics = g.getFontMetrics(font);

        g.drawString("GAME OVER", 400-metrics.stringWidth("GAME OVER")/2,100 );

        font=new Font("Arial",1,50);
        g.setFont(font);
        metrics = g.getFontMetrics(font);

        g.drawString("SCORE:", 300-metrics.stringWidth("SCORE:")/2,200 );
        g.drawString(Integer.toString(pont), 450,200 );
        timer.stop();
        Render.kep.removeKeyListener(vezerl);
        Render.kep.removeMouseListener(vezerl);
        Render.kep.addMouseListener(new Ranglista());
        timer.stop();
        clock=0;
        Ranglista.Kiir();
        pont=0;
    }


    public static void kirajzol(Graphics g){
        n = new Random();
        m = new Random();

        if(clock%(xszel+100)==0)
            rand1=n.nextInt(2)+2;

        int ertek=0;
        if(clock/2>=xszel)
            ertek = xszel-Math.abs((xszel - clock/2) % xszel);
        if(clock/2<xszel)
            ertek = Math.abs((xszel - clock/2) % xszel);

        g.setFont(new Font("Arial", 1, 100));
        g.drawImage(hatter, ertek, 0, null);
        g.drawImage(hatter, ertek-xszel, 0, null);


        ertek=ertekszamol(0,1);
        g.drawImage(fold, ertek, 500, null);
        g.drawImage(fold, ertek-xszel, 500, null);

        ertek=ertekszamol(100,1);
        for (int i = 1; i <= rand1; i++) {
            g.drawImage(kocka, ertek, 500 - (i * 80), null);
        }
        for (int i = 1; i <= rand1; i++) {
            g.drawImage(kocka, ertek, 500 - (i * 80), null);
        }

        jump();
        g.setColor(Color.orange);
        String pontod=Integer.toString(pont);
        g.drawString(pontod,50,100);

        g.drawImage(figura[(clock/100)%3],xcord,ycord+50,null);
        if(xcord+60==ertek){
            if(gameover(rand1)) {
                GameOver(g);
            }
        }
    }
}
