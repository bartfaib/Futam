package Futam.Jatek.Grafika;
import java.awt.Graphics;
import javax.swing.*;

public class Render extends JPanel{
    private static final long serialVersionUID = 1L;
    public static String menu = "menu";
    public static JFrame kep = new JFrame();
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(menu.equals("jatek")){
            Hatter.kirajzol(g);
        }
        if(menu.equals("menu")) {
            Futam.Menu.Hatter.kirajzol(g);
            repaint();
        }

        if(menu.equals("ranglista")) {
            Futam.Ranglista.Hatter.kirajzol(g);
            repaint();
        }
        if(menu.equals("nev")) {
            Futam.Nev.Hatter.kirajzol(g);
            repaint();
        }
    }

    public static void setMenu(String a) {
        menu = a;
    }
}
