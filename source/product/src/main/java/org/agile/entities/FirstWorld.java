package org.agile.entities;

public class FirstWorld {
	
	private String worldName;
	private Long worldAge, ageSpeed;
	
	public FirstWorld(String worldName){
		this.setWorldName(worldName);
		this.setWorldAge(0l);
		this.setAgeSpeed(1l);
	}
	
	public String toString(){
		return getWorldName() + "(Age: " + getWorldAge() +")";
	}

	String getWorldName() {
		return worldName;
	}

	void setWorldName(String worldName) {
		this.worldName = worldName;
	}

	Long getWorldAge() {
		return worldAge;
	}

	private void setWorldAge(Long worldAge) {
		this.worldAge = worldAge;
	}
	
	void age(){
		this.worldAge += getAgeSpeed();
	}

	private Long getAgeSpeed() {
		return ageSpeed;
	}

	private void setAgeSpeed(Long ageSpeed) {
		this.ageSpeed = ageSpeed;
	}

}
