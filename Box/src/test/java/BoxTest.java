import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;

import jdk.jfr.Timestamp;

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

    // Test if all 4 lines of a box connect to each other
    @Test
    public void UnitTest8()
    {
        System.out.println();

        String str = "M20 10.0 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ",0);
        String s;

        double arr[] = new double[10];  // horizontal
        double arr1[] = new double[10]; // vertical

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h", "");

                arr[i] = Double.parseDouble(s);
            }
        }

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v", "");

                arr1[i] = Double.parseDouble(s);
            }
        }

        double hsum = 0, vsum = 0;

        for(int i = 0; i < arr.length; i++)
            hsum += arr[i];
        
        for(int i = 0; i < arr.length; i++)
            vsum += arr1[i];
        
        if(hsum == 0 && vsum == 0)
            System.out.println("All lines connect to reach other");

        else
            System.out.println("Check coordinates?");
    }

    @Test
    public void UnitTest9()
    {
        System.out.println();

        String str = "M20 10.0 v10.0 h20.0 v-10.0 h-20.0";
        String[] spt = str.split(" ",0);
        String s;

        double arr[] = new double[10];  // horizontal
        double arr1[] = new double[10]; // vertical

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h", "");

                arr[i] = Double.parseDouble(s);
            }
        }

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v", "");

                arr1[i] = Double.parseDouble(s);
            }
        }

        double hsum = 0, vsum = 0;

        for(int i = 0; i < arr.length; i++)
            hsum += arr[i];
        
        for(int i = 0; i < arr.length; i++)
            vsum += arr1[i];
        
        if(hsum == 0 && vsum == 0)
            System.out.println("All lines connect to reach other");

        else
            System.out.println("Check coordinates?");

    }

    @Test
    public void UnitTest10()
    {
        try
        {
            String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
            String[] spt = str.split(" ",0);
            String s;
    
            double arr[] = new double[10];  // horizontal
    
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
        
            assertEquals(20.0 - 20.0,sum,0.0001);
        }

        catch(Exception e)
        {
            System.out.println("Horizontal lines don't align");
        }
    }

    @Test
    public void UnitTest11()
    {
        try
        {
            String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
            String[] spt = str.split(" ",0);
            String s;
    
            double arr[] = new double[10];  // vertical
    
            for(int i = 0; i < spt.length; i++)
            {
                if(spt[i].charAt(0) == 'v')
                {
                    s = spt[i].replace("v", "");
    
                    arr[i] = Double.parseDouble(s);
                }
            }
            
            double sum = 0;

            for(int i = 0; i < arr.length; i++)
                sum += arr[i];
        
            assertEquals(-5.0 + 5,sum,0.0001);
        }

        catch(Exception e)
        {
            System.out.println("Vertical lines don't align");
        }
    }

    // test if box has correct amount of lines
    @Test
    public void UnitTest12()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        
        int hcnt = 0, vcnt = 0;

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == 'h')
                hcnt++;
            
            if(str.charAt(i) == 'v')
                vcnt++;

        }

        if(hcnt < 2)
            System.out.println("Horizontal line missing");
        else if(hcnt > 2)
            System.out.println("Too many horizontal lines");
        
        if(vcnt < 2)
            System.out.println("Vertical line missing");
        else if(vcnt > 2)
            System.out.println("Too many vertical lines");
    }
    
    @Test
    public void UnitTest13()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                hc++;
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                wc++;
            }
        }
        
        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        boolean check = true;

        for(int i = 0; i < ht.length; i++)
        {
            if((mo[1] + ht[i]) > height)
                check = false;
        }

        if(check == true)
            System.out.println("Height of the box does not exceed the canvas's height");
        else
            System.out.println("Box is too high");
    }

    @Test
    public void UnitTest14()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                hc++;
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                wc++;
            }
        }
        
        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        boolean check = true;

        if(mo[1] + (ht[1] * -1) > height)
            check = false;
        // for(int i = 0; i < ht.length; i++)
        // {
        //     if((mo[1] + ht[i]) > height)
        //         check = false;
        // }

        if(check == true)
            System.out.println("Height of the box does not exceed the canvas's height");
        else
            System.out.println("Box is too high");
    }

    @Test
    public void UnitTest15()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                hc++;
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                wc++;
            }
        }
        
        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        boolean check = true;

        for(int i = 0; i < ht.length; i++)
        {
            if((mo[0] + wt[0] * -1) > width)
                check = false;
        }

        if(check == true)
            System.out.println("Width of the box does not exceed the canvas's width");
        else
            System.out.println("Box is too FAT");
    }
    @Test
    public void UnitTest16()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                hc++;
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                wc++;
            }
        }
        
        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        boolean check = true;

        for(int i = 0; i < ht.length; i++)
        {
            if((mo[1] + wt[i]) > height)
                check = false;
        }

        if(check == true)
            System.out.println("Width of the box does not exceed the canvas's width");
        else
            System.out.println("Box is too FAT");
    }

    @Test
    public void UnitTest17()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                hc++;
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                wc++;
            }
        }
        
        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        boolean check = true;
        double area = 0;

        area = Math.abs(ht[0] * Math.abs(wt[0]));
        
        if(area > height * width)
            check = false;

        if(check == true)
            System.out.println("Area of one side does not exceed the area of the canvas");
        else
            System.out.println("TOO BIG");
    }

    @Test
    public void UnitTest18()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s; 

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                
                if(ht[hc] < 0)
                    System.out.println("Cannot have negatives.");
                else
                    hc++; 
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                
                if(wt[wc] < 0)
                    System.out.println("Cannot have negatives.");
                else
                    wc++;            
            }
        }

    }

    @Test
    public void UnitTest19()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);

                if(ht[hc] > 100)
                    System.out.println("Out of Bounds");
                else
                    hc++;
            }
        }
    }

    @Test
    public void UnitTest20()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                
                if(wt[wc] > 100)
                    System.out.println("Out of Bounds");
                else
                    wc++;            
            }
        }
    }

    @Test
    public void UnitTest21()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;

        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        if(mo[0] % 1 != 0)
            System.out.println("Cannot move by decimal");
        if(mo[1] % 1 != 0)
            System.out.println("Cannot move by decimal");
    }

    @Test
    public void UnitTest22()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                System.out.println("Note that since using lowercase h, these are relative coordinates and not absolute.");
            }

            else if(spt[i].charAt(0) == 'v')
            {
                System.out.println("Note that since using lowercase v, these are relative coordinates and not absolute.");
            }
        }

        if(spt[0].charAt(0) == 'm')
            System.out.println("Note that since using lowercase m, these are relative coordinates and not absolute.");
    }
    @Test
    public void UnitTest23()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                hc++;
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                wc++;
            }
        }
        
        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        boolean check = true;

        for(int i = 0; i < ht.length; i++)
        {
            if((mo[1] + ht[i]) > height)
                check = false;
        }

        if(check == true)
            System.out.println("Height of the box does not exceed the canvas's height");
        else
            System.out.println("Box is too big and does not show on to the Canvas ");
    }

    @Test
    public void UnitTest24()
    {
        System.out.println();

        String str = "M20 10.0 v10.0 h20.0 v-10.0 h-20.0";
        String[] spt = str.split(" ",0);
        String s;

        double arr[] = new double[10];  // horizontal
        double arr1[] = new double[10]; // vertical

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h", "");

                arr[i] = Double.parseDouble(s);
            }
        }

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v", "");

                arr1[i] = Double.parseDouble(s);
            }
        }

        double hsum = 0, vsum = 0;

        for(int i = 0; i < arr.length; i++)
            hsum += arr[i];
        
        for(int i = 0; i < arr.length; i++)
            vsum += arr1[i];
        
        if(hsum == 0 && vsum == 0)
            System.out.println("All lines connect to reach other");

        else
            System.out.println("Please check coordinates to make sure they line up with each other.");
    }
    @Test
    public void UnitTest25()
    {
        String str = "M20 10 v-5.0 h20.0 v5.0 h-20.0";
        String[] spt = str.split(" ", 0);
        String s;

        double ht[] = new double[2];
        double wt[] = new double[2];
        double mo[] = new double[2];

        double height = 100, width = 100;
        int hc = 0, wc = 0, mc = 0; // count appearance of height and width values

        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'h')
            {
                s = spt[i].replace("h","");

                ht[hc] = Double.parseDouble(s);
                hc++;
            }

            else if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v","");

                wt[wc] = Double.parseDouble(s);
                wc++;
            }
        }
        
        String move;
        move = spt[0].replace("M","");

        mo[0] = Double.parseDouble(move);
        mo[1] = Double.parseDouble(spt[1]);

        boolean check = true;

        for(int i = 0; i < ht.length; i++)
        {
            if((mo[1] + wt[i]) > height)
                check = false;
        }

        if(check == true)
            System.out.println("Width of the box does not exceed the canvas's width");
        else
            System.out.println("Box is too big width wise and will not properly fit on the canvas");
    }

    @Test
    public void UnitTest26()
    {
        // Checks one line of a side of a box. It looks for vertical values which would indicate a tab.
        String str = "M 0.0 0.0 h1.0 v-0.25 h1.0 v0.25 h1.0 v-0.25 h1.0 v0.25 h1.0";
        String[] spt = str.split(" ",0);
        
        double mat_thick = 0.25;
    
        double hz[] = new double[5];
        double vt[] = new double[4];
    
        int cnt  = 0;
    
        for(int i = 0; i < spt.length;i++)
        {
            if(spt[i].charAt(0) == 'v')
                cnt++;
        }
    
        if(cnt == 4)
            System.out.println("Tabs are formed correctly");
        
        else
            System.out.println("Check number of tabs");
    }
    
    @Test
    public void UnitTest27()
    {
        String str = "M 0.0 0.0 h1.0 v-0.25 h1.0 v0.25 h1.0 v-0.25 h1.0 v0.25 h1.0";
        String[] spt = str.split(" ",0);
        String s;
    
        boolean is_thickness = true;
    
        double mat_thick = 0.25;
    
        for(int i = 0; i < spt.length; i++)
        {
            if(spt[i].charAt(0) == 'v')
            {
                s = spt[i].replace("v", "");
    
                if(Double.parseDouble(s) == mat_thick || Double.parseDouble(s) == (mat_thick * -1))
                    is_thickness = true;
                else
                    is_thickness = false;
            }
        }
    
        if(is_thickness)
            System.out.println("Tabs have correct depth");
        else
            System.out.println("Tabs won't fit");
    }    

    // Tab Tests ------------------------------------------
    @Test
    public void UnitTest28() {
        String tab1 = "h1.2 v0.25 h1.2 v-0.25 h1.2 v0.25 h1.2 v-0.25 h1.2";
        String opp_tab1 = "h-1.2 v-0.25 h-1.2 v0.25 h-1.2 v-0.25 h-1.2 v0.25 h-1.2";
        String[] split1 = tab1.split(" ", 0);
        String[] split2 = tab1.split(" ", 0);
        String val1, val2;

        boolean isOpposite = true;

        for(int i = 0; i < split1.length; i++) {
            if(split1[i].charAt(0) == 'h' && split2[i].charAt(0) == 'h') {
                val1 = split1[i].replace("h", "");
                val2 = split2[i].replace("h", "");

                if(Double.parseDouble(val1) != (Double.parseDouble(val2) * -1))
                    isOpposite = false;
            }
            if(split1[i].charAt(0) == 'v' && split2[i].charAt(0) == 'v') {
                val1 = split1[i].replace("v", "");
                val2 = split2[i].replace("v", "");

                if(Double.parseDouble(val1) != (Double.parseDouble(val2) * -1))
                    isOpposite = false;
            }
        }
        if(isOpposite == true)
            System.out.println("Tab has a unifying opposite side.");
        else
            System.out.println("Tab does not have a unifying opposite side.");

    }

    @Test
    public void UnitTest29() {
        String tab2 = "v1.4 h-0.25 v1.4 h0.25 v1.4 h-0.25 v1.4 h0.25 v1.4 ";
        String opp_tab2 = "v-1.4 h0.25 v-1.4 h-0.25 v-1.4 h0.25 v-1.4 h-0.25 v-1.4";
        String[] split1 = tab2.split(" ", 0);
        String[] split2 = tab2.split(" ", 0);
        String val1, val2;

        boolean isOpposite = true;

        for(int i = 0; i < split1.length; i++) {
            if(split1[i].charAt(0) == 'h' && split2[i].charAt(0) == 'h') {
                val1 = split1[i].replace("h", "");
                val2 = split2[i].replace("h", "");

                if(Double.parseDouble(val1) != (Double.parseDouble(val2) * -1))
                    isOpposite = false;
            }
            if(split1[i].charAt(0) == 'v' && split2[i].charAt(0) == 'v') {
                val1 = split1[i].replace("v", "");
                val2 = split2[i].replace("v", "");

                if(Double.parseDouble(val1) != (Double.parseDouble(val2) * -1))
                    isOpposite = false;
            }
        }
        if(isOpposite == true)
            System.out.println("Tab has a unifying opposite side.");
        else
            System.out.println("Tab does not have a unifying opposite side.");

    }

    @Test
    public void UnitTest30() {
        String tab3 = "h-1.2 v-0.25 h-1.2 v0.25 h-1.2 v-0.25 h-1.2 v0.25 h-1.2";
        String[] split = tab3.split(" ", 0);
        String val1, val2;
        int count = 0;
        double num1 = 0, num2 = 0;

        for(int i = 0; i < split.length; i++) {
            if(split[i].charAt(0) == 'v') {
                if(count == 0 || count == 2) {
                    val1 = split[i].replace("v", "");
                    num1 = Double.parseDouble(val1); 
                }
                else if(count == 1 || count == 3) {
                    val2 = split[i].replace("v", "");
                    num2 = Double.parseDouble(val2);
                }
            }
            if(count == 1 || count == 3) {
                if(num1 < 0)
                    num1 *= -1;
                if(num2 < 0)
                    num2 *= -1;

                if(num1 != num2)
                    System.out.println("Tab made successfully.");
                else
                    System.out.println("Tab NOT made successfully.");
            }
            count++;
        }
    }

    @Test
    public void UnitTest31() {
        String tab4 = "v-1.4 h0.25 v-1.4 h-0.25 v-1.4 h0.25 v-1.4 h-0.25 v-1.4";
        String[] split = tab4.split(" ", 0);
        String val1, val2;
        int count = 0;
        double num1 = 0, num2 = 0;

        for(int i = 0; i < split.length; i++) {
            if(split[i].charAt(0) == 'v') {
                if(count == 0 || count == 2) {
                    val1 = split[i].replace("v", "");
                    num1 = Double.parseDouble(val1); 
                }
                else if(count == 1 || count == 3) {
                    val2 = split[i].replace("v", "");
                    num2 = Double.parseDouble(val2);
                }
            }
            if(count == 1 || count == 3) {
                if(num1 < 0)
                    num1 *= -1;
                if(num2 < 0)
                    num2 *= -1;

                if(num1 != num2)
                    System.out.println("Tab made successfully.");
                else
                    System.out.println("Tab NOT made successfully.");
            }
            count++;
        }

    }

    @Test
    public void UnitTest32() {
        String tab5 = "h0.95 v-0.25 h1.2 v0.25 h1.2 v-0.25 h1.2 v0.25 h0.95";
        String[] split = tab5.split(" ", 0);
        String temp;
        int count = 0;

        boolean goodDesign = true;
        
        for(int i = 0; i < split.length; i++) {
            if(split[i].charAt(0) == 'h') {
                count++;
            }
            else if(split[i].charAt(0) == 'v') {
                count++;
            }
            else 
                goodDesign = false;
        }

        if(count == 9)
            System.out.println("The svg makes a proper side with tabs.");
        else
            System.out.println("The svg does not make a side with the proper tabs.");

    }
}