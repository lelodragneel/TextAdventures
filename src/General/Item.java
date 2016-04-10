package General;


public class Item {
	
	/*
	 * initialize variables
	 */
	private double damageIncrease;
	private double healthIncrease;
	
	public Item(double damageIncrease, double healthIncrease) {
		
		this.setDamageIncrease(damageIncrease);
		this.setHealthIncrease(healthIncrease);
		
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
