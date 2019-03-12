package Futam.Nev;


import Futam.Jatek.Grafika.*;
import Futam.Ranglista.Ranglista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by bartf on 2016. 11. 27..
 */
public class Nev implements MouseListener, KeyListener {

    private int lenyomas=0;




    @Override
    public void mouseClicked(MouseEvent e){
        {
            //System.out.println("Clickedmiss"+e.getX()+e.getY());

            if(     (e.getX()>325)&&
                    (e.getX()<325+150)&&
                    (e.getY()>550)&&
                    (e.getY()<630)){
                //System.out.println("ClickedBack");
                try{
                    PrintWriter writer = new PrintWriter("name","UTF-8");
                        writer.println(Hatter.name);
                    writer.close();
                   // System.out.println("Kiirtam");
                }
                catch (Exception g){System.err.println(g);}
                Render.setMenu("menu");
                Render.kep.removeMouseListener(Hatter.Listener);
                Render.kep.removeKeyListener(Hatter.Listener);
                Hatter.name="";
                Futam.Menu.Hatter hatter=new Futam.Menu.Hatter();
            }

            if(     (e.getX()>140)&&
                    (e.getX()<140+520)&&
                    (e.getY()>430)&&
                    (e.getY()<490)){
               // System.out.println("ClickedRESET");
                Ranglista.VList.clear();
                Ranglista.Kiir();
            }
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyChar()<='Z'&&e.getKeyChar()>='A') {
            if (lenyomas < 10) {
                Hatter.name += e.getKeyChar();
                lenyomas++;
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
}
