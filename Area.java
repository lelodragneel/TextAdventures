import java.util.ArrayList;
public class Area {
	boolean specialItem;
	boss miniBoss;
	String puzzle;
	//arraylist for rooms of each area
	ArrayList<String> rooms = new ArrayList<String>(10);
	public Area(boolean s,boss m, String p, ArrayList r)
	{
		specialItem = s;
		miniBoss = m;
		puzzle = p;
		rooms= r;
		s = true;
	}
	//get methods
	public boolean getS()
	{
		return specialItem;
	}
	public boss getB()
	{
		return miniBoss;
	}
	public String getP()
	{
		return puzzle;
	}
	public ArrayList getR()
	{
		return rooms;
	}
	//set methods
	public void setS(boolean s)
	{
		s = specialItem;
	}
	public void setM(boss m)
	{
		m = miniBoss;
	}
	public void setP(String p)
	{
		p = puzzle;
	}
	public void setR(ArrayList r)
	{
		r = rooms;
	}
}
