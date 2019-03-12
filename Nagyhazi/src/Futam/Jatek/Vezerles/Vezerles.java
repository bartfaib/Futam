package Futam.Jatek.Vezerles;

import Futam.Jatek.Grafika.Hatter;
import Futam.Ranglista.Versenyzok;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Vezerles  implements ActionListener, MouseListener, KeyListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Hatter.clock+=10;
        Hatter.render.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (!Hatter.jumped){
            Hatter.jumped=true;
            Hatter.ycord-=10;
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

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if (!Hatter.jumped){
                Hatter.jumped=true;
                Hatter.ycord-=10;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            if(Hatter.timer.isRunning()) {
                Hatter.timer.stop();
            }else Hatter.timer.start();
        }

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    public void beolvas (){
        try {
            Scanner file = new Scanner("name");
            file.hasNext();

        }
        catch (Exception e){System.err.println(e);}
    }
}
