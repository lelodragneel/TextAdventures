import java.util.ArrayList;

public class Area {
	
	private boolean specialItem;
	private Boss miniBoss;
	private String puzzle;
	//arraylist for rooms of each area
	private ArrayList<String> rooms = new ArrayList<String>(10);
	
	public Area(boolean specialItem, Boss miniBoss, String puzzle, ArrayList<String> rooms)
	{
		this.specialItem = specialItem;
		this.miniBoss = miniBoss;
		this.puzzle = puzzle;
		this.rooms= rooms;
		this.specialItem = true;
	}
	
	//get methods
	public boolean getSpecialItem()
	{
		return specialItem;
	}
	public Boss getMiniBoss()
	{
		return miniBoss;
	}
	public String getPuzzle()
	{
		return puzzle;
	}
	public ArrayList<String> getRooms()
	{
		return rooms;
	}
	
	//set methods
	public void setSpecialItem(boolean specialItem)
	{
		this.specialItem = specialItem;
	}
	public void setMiniBoss(Boss miniBoss)
	{
		this.miniBoss = miniBoss;
	}
	public void setPuzzle(String puzzle)
	{
		this.puzzle = puzzle;
	}
	public void setRooms(ArrayList<String> rooms)
	{
		this.rooms = rooms;
	}
}
