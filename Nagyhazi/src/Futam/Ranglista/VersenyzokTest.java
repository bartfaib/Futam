package Futam.Ranglista;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by bartf on 2016. 11. 27..
 */
public class VersenyzokTest extends TestCase {
    Versenyzok a = new Versenyzok("PETI", "5");
    public void testGetName() throws Exception {
        assertEquals(a.getName(),"PETI");

    }

    public void testGetPont() throws Exception {
        assertEquals(a.getPont(),"5");
    }

    public void testSetName() throws Exception {
        a.setName("MARCI");
        assertEquals(a.getName(),"MARCI");
    }

    public void testSetPont() throws Exception {
        a.setPont("10");
        assertEquals(a.getPont(),"10");

    }

    public void testCompareTo() throws Exception {
        Versenyzok b = new Versenyzok("Pisti","1");
        assertEquals(b.compareTo(a),1);
    }

}