import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Box 
{
	public static double height, length, width, x = 10.0, y = 5.0;
	public static String box_one, box_two, box_three, box_four, box_five, box_six, vertical, horizontal;
	public static String move = "M ";
	public static String b1 = "\"box1\"", b2 = "\"box2\"", b3 = "\"box3\"", b4 = "\"box4\"", b5 = "\"box5\"", b6 = "\"box6\"";
	public static String svg_header = "<?xml version='1.0' encoding='us-ascii'?>\n<svg height=\"1632px\" viewBox=\"0.0 0.0 120.10 81.90\" width=\"1056px\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n\n";
	public static String svg_end = "</svg>\n";
	public static String svg_base = "<g id = ";
	public static String svg_tail = "/>\n</g>\n\n";
	public static String svg_style_path = " style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n\t<path d=\"";

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
		try {
			File myObj = new File("svgtest.svg");
			if(myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("SVG file already exists.");
			}
		}	catch(IOException e) {
				System.out.println("An error occured.");
				e.printStackTrace();
		}

		// Write to file
		try {
      		FileWriter myWriter = new FileWriter("svgtest.svg");
			
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
    	} catch (IOException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
	}

	// User input
	public static void userInput() {

		System.out.println("JUJUM BOX MAKING\nPlease enter the box dimensions in order of height, length, width.\n");

		Scanner scan = new Scanner(System.in); // creates scanner

		System.out.print("Enter height: ");
		height = scan.nextDouble();
		System.out.print("Enter length: ");
		length = scan.nextDouble();
		System.out.print("Enter width: ");
		width = scan.nextDouble();

		System.out.println("The box dimensions are " + height + " " + length + " " + width + "\n");

	}

	public static void makeString() {
		String pos_vertical = Double.toString(height);
		String neg_vertical = Double.toString((height * -1));
		String pos_horizontal = Double.toString(length);
		String neg_horizontal = Double.toString((length * -1));
		String pos_width = Double.toString(width);
		String neg_width = Double.toString((width * -1));
		double reset_y, reset_y2; // have to reset y everytime to shift parts down so they dont overlap
		double reset_x;

		box_one = svg_base + b1 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(y) + " v" + neg_vertical + " h" + pos_horizontal + " v" + pos_vertical + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.20\"" + svg_tail;

		reset_y = y + height + 3;
		reset_y2 = y + height + 3;
		box_two = svg_base + b2 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(reset_y) + " v" + neg_vertical + " h" + pos_horizontal + " v" + pos_vertical + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.20\"" + svg_tail;

		reset_y = reset_y + (height/2) + y;
		box_three = svg_base + b3 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(reset_y) + " v" + neg_width + " h" + pos_horizontal + " v" + pos_width + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.20\"" + svg_tail;

		reset_y = reset_y + (height/2) + y;
		box_four = svg_base + b4 + svg_style_path + "M " + Double.toString(x) + " " + Double.toString(reset_y) + " v" + neg_width + " h" + pos_horizontal + " v" + pos_width + " h" + neg_horizontal + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.20\"" + svg_tail;

		reset_x = x + length + 3; 
		box_five = svg_base + b5 + svg_style_path + "M " + Double.toString(reset_x) + " " + Double.toString(y) + " v" + neg_width + " h" + pos_vertical + " v" + pos_width + " h" + neg_vertical + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.20\"" + svg_tail;

		box_six = svg_base + b6 + svg_style_path + "M " + Double.toString(reset_x) + " " + Double.toString(reset_y2) + " v" + neg_width + " h" + pos_vertical + " v" + pos_width + " h" + neg_vertical + "\"" + " stroke=\"rgb(0,0,0)\" stroke-width = \"0.20\"" + svg_tail;
	}
	
    public static void main( String[] args )
    {
        // System.out.println("Box 1: M 20.0 10.0 v-5.0 h20.0 v5.0 h-20.0");
		// System.out.println("Box 2: M 20.0 10.0 v10.0 h20.0 v-10.0");
		// System.out.println("Box 3: M 20.0 10.0 h-5.0 v10.0 h5.0");
		// System.out.println("Box 4: M 20.0 20.0 v5.0 h20.0 v-5.0");
		// System.out.println("Box 5: M 40.0 10.0 h5.0 v10 h-5.0");
		// System.out.println("Box 6: M 45.0 10.0 h20.0 v10.0 h-20.0");

		userInput();
		makeString();
		makeSVGFile();

    }
	
}
