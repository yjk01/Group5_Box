@Test
public void UnitTest23()
{
    // Checks one line of a side of a box. It looks for vertical values which would indicate a tab.
    String str = "M 0.0 0.0 h1.0 v-0.25 h1.0 v0.25 h1.0 v-0.25 h1.0 v0.25 h1.0";
    String[] spt = str.split(" ",0);
    
    double mat_thick = 0.25;

    double hz = new double[5];
    double vt = ne double[4];

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
public void UnitTest24()
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

            if(Double.parseDouble(s) != mat_thick)
                is_thickness = false;
        }
    }

    if(is_thickness)
        System.out.println("Tabs have correct depth");
    else
        System.out.prinln("Tabs won't fit");
}