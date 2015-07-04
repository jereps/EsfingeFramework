package com.esfinge.gamification.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.esfinge.gamification.processors.WinsToUserProcessor;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@GamificationProcessor(WinsToUserProcessor.class)
public @interface WinsToUser{
	String name();
	boolean used();
}