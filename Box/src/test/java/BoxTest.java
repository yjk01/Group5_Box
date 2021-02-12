import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;

/**
 *     Group 5
 *     Box Test Cases
 */
public class BoxTest 
{

    Box box_test;

    @Before
    public void initialize() {
        box_test = new Box();
    }

    @Test
    public void Box1() {
        try {
            string box_one = "M 20.0 10.0 v-5.0 h20.0 v5.0 h-20.0";
            string expect = box_test.Box1();
            assertEquals(box_one, expect);
        } catch (Exception e) {
            System.out.println("Box1 catch");
        }
    }

    @Test
    public void Box2() {
        try {
            string box_one = "M 20.0 10.0 v10.0 h20.0 v-10.0";
            string expect = box_test.Box2();
            assertEquals(box_one, expect);
        } catch (Exception e) {
            System.out.println("Box2 catch");
        }
    }

    @Test
    public void Box3() {
        try {
            string box_one = "M 20.0 10.0 h-5.0 v10.0 h5.0";
            string expect = box_test.Box3();
            assertEquals(box_one, expect);
        } catch (Exception e) {
            System.out.println("Box3 catch");
        }
    }

    @Test
    public void Box4() {
        try {
            string box_one = "M 20.0 20.0 v5.0 h20.0 v-5.0";
            string expect = box_test.Box4();
            assertEquals(box_one, expect);
        } catch (Exception e) {
            System.out.println("Box4 catch");
        }
    }

    @Test
    public void Box5() {
        try {
            string box_one = "M 40.0 10.0 h5.0 v10.0 h-5.0";
            string expect = box_test.Box5();
            assertEquals(box_one, expect);
        } catch (Exception e) {
            System.out.println("Box5 catch");
        }
    }

    @Test
    public void Box6() {
        try {
            string box_one = "M 45.0 10.0 h20.0 v10.0 h-20.0";
            string expect = box_test.Box6();
            assertEquals(box_one, expect);
        } catch (Exception e) {
            System.out.println("Box6 catch");
        }
    }
}
