package Futam.Menu;

import Futam.Jatek.Grafika.Render;
import Futam.Ranglista.Ranglista;

import java.awt.event.*;

/**
 * Created by bartf on 2016. 11. 24..
 */
public class Menu implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e)

    {
        //System.out.println(e.getX()+","+e.getY());
        if(     (e.getX()>277)&&
                (e.getX()<277+250)&&
                (e.getY()>130)&&
                (e.getY()<130+127)){
            //System.out.println("ClickedStart");
            Render.setMenu("jatek");
            Render.kep.removeMouseListener(this);
            //Render.kep.dispose();
            Futam.Jatek.Grafika.Hatter hatter=new Futam.Jatek.Grafika.Hatter();
        }

        if(     (e.getX()>327)&&
                (e.getX()<327+150)&&
                (e.getY()>290)&&
                (e.getY()<290+75)){
            Render.setMenu("ranglista");
            Ranglista.rendez();
            Render.kep.removeMouseListener(this);
            Futam.Ranglista.Hatter hatter=new Futam.Ranglista.Hatter();
            //System.out.println("ClickedRang");
        }

        if(     (e.getX()>327)&&
                (e.getX()<327+150)&&
                (e.getY()>390)&&
                (e.getY()<390+75)){
            Futam.Nev.Hatter hatter=new Futam.Nev.Hatter();
            Render.kep.removeMouseListener(this);
            Render.setMenu("nev");
            //System.out.println("ClickedOption");
        }

        if(     (e.getX()>327)&&
                (e.getX()<327+150)&&
                (e.getY()>490)&&
                (e.getY()<490+75)){
            //System.out.println("ClickedExit");
            System.exit(0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
