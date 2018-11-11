import model.AthleteModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AthleteModelTest {

    @Test
    public void testPoints() {

        AthleteModel a = new AthleteModel();
        a.setRunning100m("12.61");
        a.setLongJump("5.00");
        a.setShortPut("9.22");
        a.setHighJump("1.50");
        a.setRunning400m("60.39");
        a.setHurdles("16.43");
        a.setDiscusThrow("21.60");
        a.setPoleVault("2.60");
        a.setJavelinThrow("35.81");
        a.setRunning1500m(325.72);

        assertEquals(4200, a.getTotalPoints(), 0.1);
    }

    @Test
    public void testName() {

        AthleteModel a = new AthleteModel();
        a.setName("Siim Susi");

        assertEquals("Siim Susi", a.getName());
    }

    @Test
    public void test100mRunning() {

        AthleteModel a = new AthleteModel();
        a.setRunning100m("12.61");

        assertEquals(536, a.getRunning100m(), 0.1);
    }

    @Test
    public void testLongJump() {

        AthleteModel a = new AthleteModel();
        a.setLongJump("5.0");

        assertEquals(382, a.getLongJump(), 0.1);
    }

    @Test
    public void testShortPut() {

        AthleteModel a = new AthleteModel();
        a.setShortPut("9.22");

        assertEquals(439, a.getShortPut(), 0.1);
    }

    @Test
    public void testHighJump() {

        AthleteModel a = new AthleteModel();
        a.setHighJump("1.5");

        assertEquals(389, a.getHighJump(), 0.1);
    }

    @Test
    public void test400mRunning() {

        AthleteModel a = new AthleteModel();
        a.setRunning400m("60.39");

        assertEquals(400, a.getRunning400m(), 0.1);
    }

    @Test
    public void testHurdles() {

        AthleteModel a = new AthleteModel();
        a.setHurdles("16.43");

        assertEquals(685, a.getHurdles(), 0.1);
    }

    @Test
    public void testDiscusThrow() {

        AthleteModel a = new AthleteModel();
        a.setDiscusThrow("21.6");

        assertEquals(302, a.getDiscusThrow(), 0.1);
    }

    @Test
    public void testPoleVault() {

        AthleteModel a = new AthleteModel();
        a.setPoleVault("2.6");

        assertEquals(264, a.getPoleVault(), 0.1);
    }

    @Test
    public void testJavelinThrow() {

        AthleteModel a = new AthleteModel();
        a.setJavelinThrow("35.81");

        assertEquals(382, a.getJavelinThrow(), 0.1);
    }

    @Test
    public void test1500mRunning() {

        AthleteModel a = new AthleteModel();
        a.setRunning1500m(325.72);

        assertEquals(421, a.getRunning1500m(), 0.1);
    }

}
