package Futam.Ranglista;


import Futam.Jatek.Grafika.Render;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Created by bartf on 2016. 11. 27..
 */
public class Ranglista implements MouseListener{

    public static ArrayList<Versenyzok> VList=new ArrayList<Versenyzok>();

    public static File f = new File("Ranglista");



    public static void rendez(){
        Collections.sort(VList, new Comparator<Versenyzok>() {
            @Override
            public int compare(Versenyzok o1, Versenyzok o2) {
                return Integer.compare(Integer.parseInt(o2.getPont()),Integer.parseInt(o1.getPont()));
            }
        });
        Collections.sort(VList);
    }


    public static String caesarCode(String input) {

        char[] out = input.toUpperCase().toCharArray();
        for (int i = 0; i < out.length; i++) {
            if(out[i]<='Z'&&out[i]>='A') {
                out[i] += 'K' - 'A';
                if (out[i] > 'Z')
                    out[i] -= 'Z' - 'A' + 1;
            }
        }
        return new String(out);
    }

    public static String caesarDecode(String input) {
        char[] out = input.toCharArray();
        for (int i = 0; i < out.length; i++) {
            if(out[i]<='Z'&&out[i]>='A') {
                out[i] -= 'K' - 'A';
                if (out[i] < 'A')
                    out[i] += 'Z' - 'A' + 1;
            }
        }
        return new String(out);
    }

    public static void Kiir(){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            PrintWriter writer = new PrintWriter(f,"UTF-8");
            for(int i=0; i< VList.size();i++){
                String a=VList.get(i).getName()+" ";
                a=a+ VList.get(i).getPont();
                writer.println(caesarCode(a));
            }
            writer.close();
        }
        catch (Exception e){System.err.println(e);}
    }

    public static void Beolvas(){
        try {
            VList.clear();
            String line;
            BufferedReader br = new BufferedReader(new FileReader("Ranglista"));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                VList.add(Ranglista.VList.size(),new Versenyzok(caesarDecode(split[0]),caesarDecode(split[1])));
            }
        } catch (IOException e) {System.err.println(e);}
        Ranglista.rendez();
    }

    @Override
    public void mouseClicked(MouseEvent e){
        {
            //System.out.println("Clickedmiss"+e.getX()+e.getY());
            if(     (e.getX()>325)&&
                    (e.getX()<325+150)&&
                    (e.getY()>550)&&
                    (e.getY()<630)){
                //System.out.println("ClickedBack");
                Render.setMenu("menu");
                Render.kep.removeMouseListener(this);
                //Render.kep.dispose();
                Futam.Menu.Hatter hatter=new Futam.Menu.Hatter();
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

}
