package com.esfinge.gamification.achievement;

public class Wins implements Achievement {
	
	private String name;
	private boolean used;

	public Wins(String name, boolean used) {
		this.name = name;
		this.used = used;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public boolean isUsed(){
		return used;
	}

	@Override
	public void incrementAchievement(Achievement a) {
		if(!(a.getName().equals(getName()) && a instanceof Wins))
			throw new RuntimeException("The achievement should be of the same type");
		this.used = ((Wins)a).isUsed();
	}

	@Override
	public boolean removeAchievement(Achievement r) {
		if(!(r.getName().equals(getName()) && r instanceof Wins))
			throw new RuntimeException("The achievement should be of the same type");
		this.used = true;
		return false;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Wins))
			return false;
		Wins w = (Wins)o;
		return this.name.equals(w.name) && this.used == w.used;
	}

}
