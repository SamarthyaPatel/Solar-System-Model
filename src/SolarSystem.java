/***
 *  I was not introduced to JavaDoc commenting in first year, hence basic commenting is done.
 *  Version history: 1.0 - Code that is written. 2.0 - Commenting heading of the SolarSystem.java
 *  
 *  @author Samarthya Patel
 *  @version 2.0
 */

import java.util.ArrayList;

public class SolarSystem {
	private String systemName;
	private double systemLuminosity;

	private ArrayList<PlanetInSolarSystem> planetList = new ArrayList<>();

	// Constructor
	public SolarSystem(String sysName, double sysLuminosity) {

		systemName = sysName;
		systemLuminosity = sysLuminosity;
	}

	// Adds planet in the ArrayList
	public void addPlanet(String pName, double mass, double radius, double distance) {

		PlanetInSolarSystem planet = new PlanetInSolarSystem(pName, mass, radius, distance, systemLuminosity);
		planetList.add(planet);
	}

	public String toString() {
		String statement = "";
		for (PlanetInSolarSystem planet : planetList) {
			statement += planet.toString() + "\n";
		}
		return systemName + " has luminosity: " + systemLuminosity + "\n" + statement;
	}

	public static void main(String[] args) {
		SolarSystem ourSystem = new SolarSystem("Our System", 1.0);

		// Add planets in our solar system
		ourSystem.addPlanet("Mercury", 0.06, 0.38, 0.39);
		ourSystem.addPlanet("Venus", 0.82, 0.95, 0.72);
		System.out.println(ourSystem.toString());
	}
}
