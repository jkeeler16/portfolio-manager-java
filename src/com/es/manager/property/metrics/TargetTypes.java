package com.es.manager.property.metrics;

public class TargetTypes {
	
	public static enum Target {
		NONE("No Target"),
		ENERGY_STAR_SCORE("Target ENERGY STAR Score"),
		PERCENTAGE_ABOVE_BASELINE("Target % Better than Baseline"),
		PERCENTAGE_ABOVE_MEDIUM("Target % Better than Median");
		
		private final String name;
		
		private Target(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return name;
		}
	}
}
