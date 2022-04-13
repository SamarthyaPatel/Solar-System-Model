/***
 *  I was not introduced to JavaDoc commenting in first year, hence basic commenting is done.
 *  Version history: 1.0 - Code that is written. 2.0 - Commenting heading of the SolarSystem.java
 *  
 *  @author Samarthya Patel
 *  @version 2.0
 */

public class PlanetInSolarSystem {

	public static final double FRACTION_TRIMMER = 1000.0;
	public static final double LESSER1 = 0.75;
	public static final double GREATER1 = 2.0;
	public static final double LESSER2 = 0.6;
	public static final double GREATER2 = 7.0;

	private String name;
	private double mass;
	private double radius;
	private double distance;
	private double gravity;
	private double period;
	private double luminosity;
	private String answer;
	private double luminosityFactor;

	//Constructor
	public PlanetInSolarSystem(String pName, double pMass, double pRadius, double pDistance, double luminosity) {
		setName(pName);
		setMass(pMass);
		setRadius(pRadius);
		setDistance(pDistance);
		setLuminosity(luminosity);

	}

	public void setName(String pName) {
		name = pName;
	}

	public void setMass(double pMass) {
		mass = pMass;
	}

	public void setRadius(double pRadius) {
		radius = pRadius;
	}

	public void setDistance(double pDistance) {
		distance = pDistance;
	}

	public void setLuminosity(double luminosity) {
		this.luminosity = luminosity;
	}

	//Calculates for planet's habitability
	public void calculate() {
		
		//Methods are called to get data for checking the conditions
		orbitalPeriod();
		surfaceGravity();
		luminosityFactor();

		//Checks for planet's habitability
		if ((LESSER1 * luminosityFactor <= distance && distance <= GREATER1 * luminosityFactor)
				&& (LESSER2 <= mass && mass <= GREATER2)) {
			answer = "yes";
		} else {
			answer = "no";
		}
	}
	
	//Calculates orbital period
	public void orbitalPeriod() {
		period = Math.round(Math.sqrt(distance * distance * distance) * FRACTION_TRIMMER) / FRACTION_TRIMMER;
	}
	
	//Calculates surface gravity
	public void surfaceGravity() {
		gravity = Math.round((mass / (radius * radius)) * FRACTION_TRIMMER) / FRACTION_TRIMMER;
	}
	
	//Calculates luminosity factor
	public void luminosityFactor() {
		luminosityFactor = Math.round(Math.sqrt(luminosity) * FRACTION_TRIMMER) / FRACTION_TRIMMER;
	}

	public String toString() {
		//calculate() method is called to get answer
		calculate();
		return name + " has a mass of " + mass + " Earths with a surface gravity of " 
				+ gravity + "g, is " 
				+ distance + "AU from its star, and orbits in " 
				+ period + " years: could be habitable? " 
				+ answer;
	}
}


