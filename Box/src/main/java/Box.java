import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Box 
{
	public static double height, length, width;	// dimension of box
	public static double x = 0.1, y = 0.1;		// starting point
	public static double thick = 0;				// holds thickness of material

	public static String box_one = ""; 
	public static String box_two, box_three, box_four, box_five, box_six, vertical, horizontal;
	public static String f1, f2, f3, f4, f5, f6;

    public static String file_name;

	public static String move = "M ";
	public static String b1 = "\"box1\"", b2 = "\"box2\"", b3 = "\"box3\"", b4 = "\"box4\"", b5 = "\"box5\"", b6 = "\"box6\"";
	public static String svg_header = "<?xml version='1.0' encoding='us-ascii'?>\n<svg height=\"18in\" viewBox=\"0.0 0.0 24.0 18.0\" width=\"24in\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n\n";
	public static String svg_end = "</svg>\n";
	public static String svg_base = "<g id = ";
	public static String svg_tail = "/>\n</g>\n\n";
	public static String svg_style_path = " style=\"fill:none;stroke-linecap:round;stroke-linejoin:straight;\">\n\t<path d=\"";
	public static String stroke = "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.01\"";

    public String box1()
	{
		return "M 20.0 10.0 v-5.0 h20.0 v5.0 h-20.0";
	}

	public String box2()
	{
		return "M 20.0 10.0 v10.0 h20.0 v-10.0";
	}

	public String box3()
	{
		return "M 20.0 10.0 h-5.0 v10.0 h5.0";
	}

	public String box4()
    {
        return "M 20.0 20.0 v5.0 h20.0 v-5.0";
    }

    public String box5()
    {
        return "M 40.0 10.0 h5.0 v10 h-5.0";
    }

    public String box6()
    {
        return "M 45.0 10.0 h20.0 v10.0 h-20.0";
    }

	public static void makeSVGFile() {
		// Make File
		try 
		{
			File myObj = new File(file_name + ".svg");

			if(myObj.createNewFile()) 
				System.out.println("File created: " + myObj.getName());

			else 
				System.out.println("SVG file already exists.");

		}	catch(IOException e) 
		{
				System.out.println("An error occured.");

				e.printStackTrace();
		}

		// Write to file
		try {
      		FileWriter myWriter = new FileWriter(file_name + ".svg");
			
			// Steps of writing SVG file
      		myWriter.write(svg_header); // writes the SVG header 
			myWriter.write(box_one);
			myWriter.write(box_two);
			myWriter.write(box_three);
			myWriter.write(box_four);
			myWriter.write(box_five);
			myWriter.write(box_six);

			// end of SVG file
			myWriter.write(svg_end);
      		myWriter.close();

      		System.out.println("Successfully wrote to the SVG file.");
    	} 
		
		catch (IOException e) 
		{
      		System.out.println("An error occurred.");

      		e.printStackTrace();
    	}
	}

	// User input
	public static void userInput() 
	{
		System.out.println("JUJUM BOX MAKING\nPlease enter the box dimensions in order of height, length, width.\n");

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter height: ");
		height = scan.nextDouble();

		System.out.print("Enter length: ");
		length = scan.nextDouble();

		System.out.print("Enter width: ");
		width = scan.nextDouble();

		System.out.print("Enter material thickness: ");
		thick = scan.nextDouble();

        System.out.print("Enter file name for svg code: ");
        file_name = scan.next();

		System.out.println("The box dimensions are " + height + " " + length + " " + width + "\n");
	}

	public static void makeS()
	{
        double nx = 0, ny = 0, nz = 0; // variables that hold the divided measurements
        boolean down = false;          // checks if line started to draw down / up
        boolean side = false;          // check if line started to drawn left / right

		// initialize variables to avoid "null" from printing in the svg code
		f1 = f2 = f3 =  "";
		box_two = box_three = box_four = box_five = box_six = "";

        nx = length / 5;
        ny = height / 5;
        nz = width / 5;
        
		// ---------------------------------- Face One ------------------------------------------------------------
        
		//  top line
        for(int i = 0; i < 9; i++)
        {
            if(i % 2 == 0)
            {
                f1 += "h" + Double.toString(nx) + " ";
            }
            
            else if(i % 2 == 1 && down == false)
            {
                f1 += "v" + Double.toString(thick) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == true)
            {
                f1 += "v" + Double.toString(thick * -1) + " ";
                down = !down;
            }
        }

        f1 += "\n";

        down = !down;
        
        // right line
        for(int i = 0; i < 9; i++)
        {
            if(i % 2 == 0)
            {
                f1 += "v" + Double.toString(nz) + " ";
            }
            
            else if(i % 2 == 1 && down == false)
            {
                f1 += "h" + Double.toString(thick) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == true)
            {
                f1 += "h" + Double.toString(thick * -1) + " ";
                down = !down;
            }
        }

        f1 += "\n";

        // bottom line
        for(int i = 0; i < 9; i++)
        {
            if(i % 2 == 0)
            {
                f1 += "h" + Double.toString(nx * -1) + " ";
            }
            
            else if(i % 2 == 1 && down == false)
            {
                f1 += "v" + Double.toString(thick) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == true)
            {
                f1 += "v" + Double.toString(thick * -1) + " ";
                down = !down;
            }
        }

        f1 += "\n";
        down = !down;

        // left line
        for(int i = 0; i < 9; i++)
        {
            if(i % 2 == 0)
            {
                f1 += "v" + Double.toString(nz * -1) + " ";
            }
            
            else if(i % 2 == 1 && down == false)
            {
                f1 += "h" + Double.toString(thick) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == true)
            {
                f1 += "h" + Double.toString(thick * -1) + " ";
                down = !down;
            }
        }

        System.out.println(f1 + "\n");

		box_one += svg_base + b1 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(y) + " ";
		box_one += f1 + stroke + svg_tail;

		box_two += svg_base + b2 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(y + width + 0.5) + " ";
		box_two += f1 + stroke + svg_tail;

		// ---------------------------FACE TWO -----------------------------
		down  = true;

        // top line
        for(int i = 0; i < 9; i++)
        {
            if( i % 2 == 0 && (i == 0 || i == 8))
            {
                f2 += "h" + Double.toString(nx - thick) + " ";
            }

            else if(i % 2 == 0 && (i != 0 && i != 8))
            {
                f2 += "h" + Double.toString(nx) + " ";
            }

            else if(i % 2 == 1 && down == true)
            {
                f2 += "v" + Double.toString(thick * -1) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == false)
            {
                f2 += "v" + Double.toString(thick) + " ";
                down = !down;
            }
        }

        f2 += "\n";
        down = !down;

        // right line
        for(int i = 0; i < 9; i++)
        {
            if( i % 2 == 0 && (i == 0 || i == 8))
            {
                f2 += "v" + Double.toString(ny - thick) + " ";
            }

            else if(i % 2 == 0 && (i != 0 || i != 8))
            {
                f2 += "v" + Double.toString(ny) + " ";
            }
            else if(i % 2 == 1 && down == true)
            {
                f2 += "h" + Double.toString(thick * -1) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == false)
            {
                f2 += "h" + Double.toString(thick) + " ";
                down = !down;
            }

        }

        f2 += "\n";

        // bottom line
        for(int i = 0; i < 9; i++)
        {
            if( i % 2 == 0 && (i == 0 || i == 8))
            {
                f2 += "h" + Double.toString((nx - thick) * -1) + " ";
            }

            else if(i % 2 == 0 && (i != 0 && i != 8))
            {
                f2 += "h" + Double.toString(nx * -1) + " ";
            }

            else if(i % 2 == 1 && down == true)
            {
                f2 += "v" + Double.toString(thick * -1) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == false)
            {
                f2 += "v" + Double.toString(thick) + " ";
                down = !down;
            }
        }

        f2 += "\n";
        down = !down;

        // left line
        for(int i = 0; i < 9; i++)
        {
            if( i % 2 == 0 && (i == 0 || i == 8))
            {
                f2 += "v" + Double.toString((ny - thick) * -1) + " ";
            }

            else if(i % 2 == 0 && (i != 0 || i != 8))
            {
                f2 += "v" + Double.toString(ny * -1) + " ";
            }
            else if(i % 2 == 1 && down == true)
            {
                f2 += "h" + Double.toString(thick * -1) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == false)
            {
                f2 += "h" + Double.toString(thick) + " ";
                down = !down;
            }
        }    

        System.out.println(f2 + "\n");

        // removed thickness from M, just to adjust some spacing issue
		box_three += svg_base + b3 + svg_style_path + "M " + Double.toString(x + length + 0.5) + " " + Double.toString(y + thick) + " ";
		box_three += f2 + stroke + svg_tail;

		box_four += svg_base + b4 + svg_style_path + "M " + Double.toString(x + length + 0.5) + " " + Double.toString(y + thick + height + 0.5) + " ";
		box_four += f2 + stroke + svg_tail;

        // --------------- face 3 --------------------
        down = true;

        // top line
        for(int i = 0; i < 9; i++)
        {
            if(i % 2 == 0)
            {
                f3 += "h" + Double.toString(nz) + " ";
            }
            
            else if(i % 2 == 1 && down == false)
            {
                f3 += "v" + Double.toString(thick) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == true)
            {
                f3 += "v" + Double.toString(thick * -1) + " ";
                down = !down;
            }
        }

        f3 += "\n";

        // right
        for(int i = 0; i < 9; i++)
        {
            if( i % 2 == 0 && (i == 0 || i == 8))
            {
                f3 += "v" + Double.toString(ny - thick) + " ";
            }

            else if(i % 2 == 0 && (i != 0 || i != 8))
            {
                f3 += "v" + Double.toString(ny) + " ";
            }
            else if(i % 2 == 1 && down == true)
            {
                f3 += "h" + Double.toString(thick * -1) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == false)
            {
                f3 += "h" + Double.toString(thick) + " ";
                down = !down;
            }
        }

        f3 += "\n";

        down = !down;

        // bottom line
        for(int i = 0; i < 9; i++)
        {
            if(i % 2 == 0)
            {
                f3 += "h" + Double.toString(nz * -1) + " ";
            }
            
            else if(i % 2 == 1 && down == false)
            {
                f3 += "v" + Double.toString(thick) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == true)
            {
                f3 += "v" + Double.toString(thick * -1) + " ";
                down = !down;
            }
        }

        f3 += "\n";
        
        // left line
        for(int i = 0; i < 9; i++)
        {
            if( i % 2 == 0 && (i == 0 || i == 8))
            {
                f3 += "v" + Double.toString((ny - thick) * -1) + " ";
            }

            else if(i % 2 == 0 && (i != 0 || i != 8))
            {
                f3 += "v" + Double.toString(ny * -1) + " ";
            }
            else if(i % 2 == 1 && down == true)
            {
                f3 += "h" + Double.toString(thick * -1) + " ";
                down = !down;
            }

            else if(i % 2 == 1 && down == false)
            {
                f3 += "h" + Double.toString(thick) + " ";
                down = !down;
            }
        }

        System.out.println(f3);

		box_five += svg_base + b5 + svg_style_path + "M " + Double.toString(x + length + length + 0.5 + thick) + " " + Double.toString(y + thick) + " ";
		box_five += f3 + stroke + svg_tail;

		box_six += svg_base + b6 + svg_style_path + "M " + Double.toString(x + length + length + 0.5 + thick) + " " + Double.toString(y + thick + height + 0.5) + " ";
		box_six += f3 + stroke + svg_tail;

    }
	/*public static void makeString() {
		String pos_vertical = Double.toString(height);
		String neg_vertical = Double.toString(height * -1);
		String pos_horizontal = Double.toString(length);
		String neg_horizontal = Double.toString(length * -1);
		String pos_width = Double.toString(width);
		String neg_width = Double.toString(width * -1);
		double reset_y, reset_y2, reset_y3, reset_y4; // have to reset y everytime to shift parts down so they dont overlap
		double reset_x;

		box_one = svg_base + b1 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(y) + " v" + pos_vertical + " h" + pos_horizontal + " v" + neg_vertical + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.10\"" + svg_tail;

		reset_y = (y + height + 0.5);

		box_two = svg_base + b2 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(reset_y) + " v" + pos_vertical + " h" + pos_horizontal + " v" + neg_vertical + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.10\"" + svg_tail;
		
		//reset_y2 = (reset_y + height + 0.5);
		//reset_y = (reset_y + (height/2) + y);
		reset_y2 = reset_y * 1.8;
		box_three = svg_base + b3 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(reset_y2) + " v" + pos_width + " h" + pos_horizontal + " v" + neg_width + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.10\"" + svg_tail;

		// reset_y3 = reset_y2 +width+ 0.5;
		reset_y3 = reset_y2 * 1.2;
		box_four = svg_base + b4 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(reset_y3) + " v" + pos_width + " h" + pos_horizontal + " v" + neg_width + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.10\"" + svg_tail;

		reset_x = (x + length + 1.5); 
		box_five = svg_base + b5 + svg_style_path + "M " + Double.toString(reset_x) + " " + Double.toString(y) + " v" + pos_width + " h" + pos_vertical + " v" + neg_width + " h" + neg_vertical + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.10\"" + svg_tail;

		reset_y4 = y + width + 0.5;
		box_six = svg_base + b6 + svg_style_path + "M " + Double.toString(reset_x) + " " + Double.toString(reset_y4) + " v" + pos_width + " h" + pos_vertical + " v" + neg_width + " h" + neg_vertical + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.10\"" + svg_tail;
	}*/
	
    public static void main( String[] args )
    {
        // System.out.println("Box 1: M 20.0 10.0 v-5.0 h20.0 v5.0 h-20.0");
		// System.out.println("Box 2: M 20.0 10.0 v10.0 h20.0 v-10.0");
		// System.out.println("Box 3: M 20.0 10.0 h-5.0 v10.0 h5.0");
		// System.out.println("Box 4: M 20.0 20.0 v5.0 h20.0 v-5.0");
		// System.out.println("Box 5: M 40.0 10.0 h5.0 v10 h-5.0");
		// System.out.println("Box 6: M 45.0 10.0 h20.0 v10.0 h-20.0");

		userInput();
		makeS();
		// makeString();
		makeSVGFile();

    }
	
}
