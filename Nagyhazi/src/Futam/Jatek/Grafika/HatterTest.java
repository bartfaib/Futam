package Futam.Jatek.Grafika;

import junit.framework.TestCase;

/**
 * Created by bartf on 2016. 11. 27..
 */
public class HatterTest extends TestCase {
    public void testGameover() throws Exception {
        assertTrue(Hatter.gameover(5));
    }

    public void testErtekszamol() throws Exception {
        assertTrue(Hatter.ertekszamol(200,2)<800);
    }

}