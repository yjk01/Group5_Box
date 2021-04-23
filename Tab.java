import java.util.Scanner;

public class Tab
{
    public static String svg_header = "<?xml version='1.0' encoding='us-ascii'?>\n<svg height=\"18in\" viewBox=\"0.0 0.0 24.0 18.0\" width=\"24in\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n\n";
	public static String svg_end = "</svg>\n";
	public static String svg_base = "<g id = ";
	public static String svg_tail = "/>\n</g>\n\n";
	public static String svg_style_path = " style=\"fill:none;stroke-linecap:round;stroke-linejoin:straight;\">\n\t<path d=\"";

    public static String f1 = "";   // string that'll hold the svg code for face 1
    public static String f2 = "";
    public static double x,y,z;     // dimensions of the box
    public static double thick = 0; // hold thickness of material used

    //public static String mat_thickness = Double.toString(thick); // thickness of the material

    public static void userInput()
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter x: ");
        x = scan.nextDouble();

        System.out.print("Enter y: ");
        y = scan.nextDouble();

        System.out.print("Enter z: ");
        z = scan.nextDouble();

        System.out.print("Enter thickness of material in decimal form: ");
        thick = scan.nextDouble();

    }
    public static void makeS()
    {
        double nx = 0, ny = 0, nz = 0; // variables that hold the divided measurements
        boolean down = false;          // checks if line started to draw down
        boolean side = false;          // chec

        nx = x / 5;
        ny = y / 5;
        nz = z / 5;
        
        // for loop that generates the top line for face 1
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
        
        // for loop that generates the right line for face 1
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

        // for loop that generates the bottom line for face 1
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

        // for loop that generates the left line for face 1
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

// -------------------------- FACE TWO -------------------------------

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

        System.out.println(f2);
    }

    public static void main(String[] args)
    {
        userInput();
        makeS();
    }
}