package quentin.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    private Color colorRgb;
    private Color colorHex;

    @BeforeEach
    public void setUp(){
        colorRgb = new Color(210,105,30);
        colorHex = new Color("#D2691E");
    }

    @AfterEach
    public void tearDown(){
        colorRgb = null;
        colorHex = null;
    }

    @Test
    public void testConstructor3ArgThrowException(){
        assertThrows(IllegalArgumentException.class, () -> new Color(0,256,-25));
    }

    @Test
    public void testConstructor1ArgThrowException(){
        assertThrows(IllegalArgumentException.class, () -> new Color("#9400Z3"));
    }

    @Test
    public void testGetRed(){
        assertEquals(210, colorRgb.getRed());
    }

    @Test
    public void testSetRed(){
        colorRgb.setRed(28);
        assertEquals(28, colorRgb.getRed());
        assertEquals(105, colorRgb.getGreen());
        assertEquals(30, colorRgb.getBlue());
        assertEquals(String.format("%02X", 28) ,colorRgb.getHexValue().substring(1,3));
    }

    @Test
    public void testSetRedThrowException(){
        assertThrows(IllegalArgumentException.class, () -> colorRgb.setRed(258));
    }

    @Test
    public void testGetGreen(){
        assertEquals(105, colorRgb.getGreen());
    }

    @Test
    public void testSetGreen(){
        colorRgb.setGreen(28);
        assertEquals(28, colorRgb.getGreen());
        assertEquals(210, colorRgb.getRed());
        assertEquals(30, colorRgb.getBlue());
        assertEquals(String.format("%02X", 28) ,colorRgb.getHexValue().substring(3,5));
    }

    @Test
    public void testSetGreenThrowException(){
        assertThrows(IllegalArgumentException.class, () -> colorRgb.setGreen(-18));
    }

    @Test
    public void testGetBlue(){
        assertEquals(30, colorRgb.getBlue());
    }

    @Test
    public void testSetBlue(){
        colorRgb.setBlue(28);
        assertEquals(28, colorRgb.getBlue());
        assertEquals(210, colorRgb.getRed());
        assertEquals(105, colorRgb.getGreen());
        assertEquals(String.format("%02X", 28) ,colorRgb.getHexValue().substring(5,7));
    }

    @Test
    public void testSetBlueThrowException(){
        assertThrows(IllegalArgumentException.class, () -> colorRgb.setBlue(-1));
    }

    @Test
    public void testGetHexValue(){
        assertEquals("#D2691E", colorRgb.getHexValue());
    }

    @Test
    public void testSetHexValue(){
        colorRgb.setHexValue("#BC8F8F");
        assertEquals("#BC8F8F", colorRgb.getHexValue());
        assertEquals(188, colorRgb.getRed());
        assertEquals(143, colorRgb.getGreen());
        assertEquals(143, colorRgb.getBlue());
    }

}