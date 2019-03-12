package Futam;


import Futam.Jatek.Grafika.HatterTest;
import Futam.Ranglista.RanglistaTest;
import Futam.Ranglista.VersenyzokTest;
import junit.framework.TestSuite;

public class Main {
    public static void main(String[] args) {
        Futam.Menu.Hatter menu=new Futam.Menu.Hatter();

        junit.textui.TestRunner.run(new TestSuite(VersenyzokTest.class));
        junit.textui.TestRunner.run(new TestSuite(RanglistaTest.class));
        junit.textui.TestRunner.run(new TestSuite(HatterTest.class));
        }


    }