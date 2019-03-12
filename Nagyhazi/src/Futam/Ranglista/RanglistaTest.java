package Futam.Ranglista;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RanglistaTest extends TestCase {
    public void testRendez() throws Exception {
        assertTrue(Integer.parseInt(Ranglista.VList.get(0).getPont())>=Integer.parseInt(Ranglista.VList.get(1).getPont()));
    }

    public void testCaesarCode() throws Exception {
        assertEquals(Ranglista.caesarCode("ALMA"),("KVWK"));
    }

    public void testCaesarDecode() throws Exception {
        assertEquals(Ranglista.caesarDecode("KVWK"),("ALMA"));
    }

    public void testKiir() throws Exception {
        File f = new File("name");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s =br.readLine();
        assertNotNull(s);
    }

}