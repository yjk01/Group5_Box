
public class Box 
{
	public String box1()
	{
		return "M 20.0 10.0 v-5.0 h 20.0 v5.0 h-20.0";
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

	
    public static void main( String[] args )
    {
        System.out.println("Box 1: M 20.0 10.0 v-5.0 h20.0 v5.0 h-20.0");
		System.out.println("Box 2: M 20.0 10.0 v10.0 h20.0 v-10.0");
		System.out.println("Box 3: M 20.0 10.0 h-5.0 v10.0 h5.0");
		System.out.println("Box 4: M 20.0 20.0 v5.0 h20.0 v-5.0");
		System.out.println("Box 5: M 40.0 10.0 h5.0 v10 h-5.0");
		System.out.println("Box 6: M 45.0 10.0 h20.0 v10.0 h-20.0");
    }
	
}
