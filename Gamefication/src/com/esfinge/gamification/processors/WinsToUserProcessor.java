package com.esfinge.gamification.processors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.esfinge.gamification.achievement.Wins;
import com.esfinge.gamification.annotation.WinsToUser;
import com.esfinge.gamification.mechanics.Game;
import com.esfinge.gamification.user.UserStorage;


public class WinsToUserProcessor implements AchievementProcessor{

	private boolean used;
	private String name;
	
	
	public void receiveAnnotation(Annotation an) {
		
		WinsToUser wtu = (WinsToUser) an;
		used = wtu.used();
		name = wtu.name();
	}
	
	
	public void process(Game game, Object encapsulated, Method method, Object[] args) {
		
		Object user = UserStorage.getUserID();
		Wins w = new Wins(name, used);
		game.addAchievement(user, w);
		
	}

}
