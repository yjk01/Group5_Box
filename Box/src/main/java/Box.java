
public class Box 
{
	public String box1()
	{
		return("Box 1: M 20.0 10.0 v -5.0 h 20.0 v 5.0 h -20.0");
	}
	public String box2()
	{
		return("Box 2: M 20.0 10.0 v 10.0 h 20.0 v -10.0"
	}
	public String box3()
	{
		return("Box 3: M 20.0 10.0 h-5.0 v10.0 h 5.0");
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Box 1: M 20.0 10.0 v -5.0 h 20.0 v 5.0 h -20.0" );
		System.out.println( "Box 2: M 20.0 10.0 v 10.0 h 20.0 v -10.0");
		System.out.println( "Box 3: M 20.0 10.0 h-5.0 v10.0 h 5.0");
    }
	
}
