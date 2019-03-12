package Futam.Ranglista;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by bartf on 2016. 11. 27..
 */
public class Versenyzok implements Comparable<Versenyzok>, Serializable{
    private String name="";
    private String pont="0";

    public Versenyzok(String name, String pont){
        if(name.length()<10)
            this.name=name;
        if(name.equals("")||name.equals(" "))
            this.name="STANDARD";
        if(name.length()>=10) {
            StringBuilder a = new StringBuilder("1234567890");
            for(int i=0; i<10;i++)
                a.setCharAt(i,name.charAt(i));
            this.name=a.toString();
        }
        this.pont= pont;
    }

    public String getName(){
        return this.name;
    }
    public String getPont(){
        return this.pont;
    }
    public void setName(String name){
        if(name.length()<15)
            this.name=name;
        else {
            StringBuilder a = new StringBuilder(name);
            for(int i=0; i<20;i++)
                a.setCharAt(i,name.charAt(i));
            this.name=a.toString();
        }
    }

    public void setPont(String pont){
        this.pont=pont;
    }

    public int compareTo(Versenyzok v){
        if((Integer.parseInt(v.pont))<(Integer.parseInt(this.pont)))
            return 0;
        return 1;
    }


}
