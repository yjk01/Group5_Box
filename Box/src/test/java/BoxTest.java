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
            String box_one = "M 20.0 10.0 v-5.0 h20.0 v5.0 h-20.0";
            String expect = box_test.box1();
            assertEquals(box_one, expect);
            System.out.println("Box 1: M 20.0 10.0 v-5.0 h20.0 v5.0 h-20.0");
        } catch (Exception e) {
            System.out.println("Box1 catch");
        }
    }

    @Test
    public void Box2() {
        try {
            String box_one = "M 20.0 10.0 v10.0 h20.0 v-10.0";
            String expect = box_test.box2();
            assertEquals(box_one, expect);
            System.out.println("Box 2: M 20.0 10.0 v10.0 h20.0 v-10.0");
        } catch (Exception e) {
            System.out.println("Box2 catch");
        }
    }

    @Test
    public void Box3() {
        try {
            String box_one = "M 20.0 10.0 h-5.0 v10.0 h5.0";
            String expect = box_test.box3();
            assertEquals(box_one, expect);
            System.out.println("Box 3: M 20.0 10.0 h-5.0 v10.0 h5.0");
        } catch (Exception e) {
            System.out.println("Box3 catch");
        }
    }

    @Test
    public void Box4() {
        try {
            String box_one = "M 20.0 20.0 v5.0 h20.0 v-5.0";
            String expect = box_test.box4();
            assertEquals(box_one, expect);
            System.out.println("Box 4: M 20.0 20.0 v5.0 h20.0 v-5.0");
        } catch (Exception e) {
            System.out.println("Box4 catch");
        }
    }

    @Test
    public void Box5() {
        try {
            String box_one = "M 40.0 10.0 h5.0 v10 h-5.0";
            String expect = box_test.box5();
            assertEquals(box_one, expect);
            System.out.println("Box 5: M 40.0 10.0 h5.0 v10 h-5.0");
        } catch (Exception e) {
            System.out.println("Box5 catch");
        }
    }

    @Test
    public void Box6() {
        try {
            String box_one = "M 45.0 10.0 h20.0 v10.0 h-20.0";
            String expect = box_test.box6();
            assertEquals(box_one, expect);
            System.out.println("Box 6: M 45.0 10.0 h20.0 v10.0 h-20.0");
        } catch (Exception e) {
            System.out.println("Box6 catch");
        }
    }
    
    /*
     
     Unit Tests ---------------------------------------------------------------------------------------------------
     
     */
    
    @Test
    public void UnitTest1() {
        String svg = "M 20.0 10.0 v-5.0 h20.0";
        int length = svg.indexOf("v");
        if (length < 0) {
                System.out.println("Vertical line not found");
        } else {
                System.out.println("Vertical line at index " + length);
            }
    }
    
    @Test
    public void UnitTest2() {
        String svg = "M 20.0 10.0 v-5.0 h20.0";
        int width = svg.indexOf("h");
        if (width < 0) {
                System.out.println("Horizontal line not found");
        } else {
                System.out.println("Horizontal line at index " + width);
            }
    }
}
