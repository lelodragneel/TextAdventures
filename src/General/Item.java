package General;


public class Item {
	
	/*
	 * initialize variables
	 */
	private int damageIncrease;
	private int healthIncrease;
	private String itemName;
	
	public Item(int damageIncrease, int healthIncrease, String itemName) {
		
		this.damageIncrease = damageIncrease;
		this.healthIncrease = healthIncrease;
		this.itemName = itemName;
		
	}

	public double getDamageIncrease() {
		return damageIncrease;
	}

	public void setDamageIncrease(int damageIncrease) {
		this.damageIncrease = damageIncrease;
	}

	public double getHealthIncrease() {
		return healthIncrease;
	}

	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
	
}
