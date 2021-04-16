import java.util.Scanner;

public class Box
{
  public static double height, width;

  public static void Input()
  {
    Scanner scan = new Scanner(System.in);

    System.out.print("Height? ");
    height = scan.nextDouble();

    System.out.print("Width? ");
    width = scan.nextDouble();

    height *= 96;
    width *= 96;


  }

  public static void Output()
  {
      System.out.println("Height = " + height);

      System.out.println("Width = " + width);
  }
  public static void main(String[] args)
  {
    Input();
    Output();
  }
}