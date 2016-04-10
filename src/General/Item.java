package General;


public class Item {
	
	/*
	 * initialize variables
	 */
	private int damageIncrease;
	private int healthIncrease;
	private String itemName;
	
	public Item(int damageIncrease, int healthIncrease, String name) {
		
		this.setDamageIncrease(damageIncrease);
		this.setHealthIncrease(healthIncrease);
		itemName = name;
	}

	public double getDamageIncrease() {
		return damageIncrease;
	}

	public void setDamageIncrease(double damageIncrease) {
		this.damageIncrease = damageIncrease;
	}

	public double getHealthIncrease() {
		return healthIncrease;
	}

	public void setHealthIncrease(double healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
	
}
