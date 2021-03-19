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

        System.out.println();

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

    @Test
    public void UnitTest3()
    {
        System.out.println();

        String str = "M20 10.0 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);

        System.out.println("Vertical lines found with heights of: ");

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'v')
                System.out.println(spt[i]);
        }
    }

    @Test
    public void UnitTest4()
    {
        System.out.println();

        String str = "M20 10.0 v10.0 h20.0 v-10.0 h-20.0";
        String[] spt = str.split(" ", 0);

        System.out.println("Vertical lines found with heights of: ");
        
        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'v')
                System.out.println(spt[i]);
        }
    }

    @Test
    public void UnitTest5()
    {
        System.out.println();

        String str = "M20 10.0 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);

        System.out.println("Horizontal lines found with lengths of: ");
        
        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                for(int j = 1; j < spt[i].length(); j++)
                {
                    System.out.print(spt[i].charAt(j));
                }
                System.out.println();
            }
        }
    }

    @Test
    public void UnitTest6()
    {
        System.out.println();

        String str = "M40.0 10.0 h5.0 v10.0 h-5.0";
        String[] spt = str.split(" ", 0);

        System.out.println("Horizontal lines found with lengths of: ");
        
        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                for(int j = 1; j < spt[i].length(); j++)
                {
                    System.out.print(spt[i].charAt(j));
                }
                System.out.println();
            }
        }
    }

    // test for uniformity of lengths
    @Test
    public void UnitTest7()
    {
        System.out.println();

        String str = "M20 10.0 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double arr[] = new double[10];
        
        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                 s = spt[i].replace("h", "");

                arr[i] = Double.parseDouble(s);
            }
        }

        double sum = 0;

        for(int i = 0; i < arr.length; i++)
            sum += arr[i];

        if(sum == 0.0)
            System.out.println("All horizontal lines are the same length");

        else
            System.out.println("Fix Horizonatal lines");
    }


}
