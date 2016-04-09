
public class character {
	private String type;
	private String name;
	private String weapon;
	private int health;
	private int attack;
	private boolean potion;
	private int keyCount;
	private int item;
	public character(String t, String n, String w, int h, int a, boolean p, int k, int i){
		type = t;
		name = n;
		weapon = w;
		health = h;
		attack = a;
		potion = p;
		keyCount = k;
		item = i;
		keyCount = 0; 
		item = 0;
		potion = false; 
	}
	//get methods
	public String getT()
	{
		return type;
	}
	public String getN()
	{
		return name;
	}
	public String getW()
	{
		return weapon;
	}
	public int getH()
	{
		return health;
	}
	public int getA()
	{
		return attack;
	}
	public boolean getP()
	{
		return potion;
	}
	public int getK()
	{
		return keyCount;
	}
	public int getI()
	{
		return item;
	}
	//set methods
	public void setT(String t)
	{
		t = type;
	}
	public void setN(String n)
	{
		n = name;
	}
	public void setW(String w)
	{
		w = weapon; 
	}
	public void setH(int h)
	{
		h = health;
	}
	public void setA(int a)
	{
		a = attack;
	}
	public void setP(boolean p)
	{
		p = potion;
	}
	public void setK(int k)
	{
		k = keyCount;
	}
	public void setI(int i)
	{
		i = item;
	}
}
