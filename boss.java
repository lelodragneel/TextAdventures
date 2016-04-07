
public class boss {
	int health, attack;
	String name; 
	public boss(int h, int a, String n)
	{
		health = h;
		attack = a;
		name = n;
	}
	//get methods
	public int getH()
	{
		return health;
	}
	public int getA()
	{
		return attack;
	}
	public String getN()
	{
		return name;
	}
	//set methods
	public void setH(int h)
	{
		h = health;
	}
	public void setA(int a)
	{
		a = attack;
	}
	public void setN(String n)
	{
		n = name;
	}	
}
