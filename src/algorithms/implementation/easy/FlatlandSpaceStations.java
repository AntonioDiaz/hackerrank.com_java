package algorithms.implementation.easy;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class FlatlandSpaceStations {

	public static void main(String[] args) throws Exception {
		InputStream input = FlatlandSpaceStations.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "flatland_space_stations.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int citiesNumber = in.nextInt();
		int spaceStationsNumber = in.nextInt();
		int maxDistance = Integer.MIN_VALUE;
		Set<Integer> citiesWithSpaceStation = new HashSet<Integer>();
		for (int i = 0; i < spaceStationsNumber; i++) {
			citiesWithSpaceStation.add(in.nextInt());
		}
		int citiesWithoutSpaceStation = 0;
		boolean isFirst = true;
		for (int i = 0; i < citiesNumber; i++) {
			if (citiesWithSpaceStation.contains(i)) {
				if (isFirst) {
					maxDistance = citiesWithoutSpaceStation;
					isFirst = false;
				} else {
					int maxDistanceAux = (citiesWithoutSpaceStation + 1) / 2;
					if (maxDistanceAux>maxDistance) {
						maxDistance = maxDistanceAux;
					}
				}
				citiesWithoutSpaceStation = 0;
			} else {
				citiesWithoutSpaceStation++;
			}
		}
		if (citiesWithoutSpaceStation>0 && maxDistance<citiesWithoutSpaceStation) {
			maxDistance = citiesWithoutSpaceStation;
		}
		System.out.println(maxDistance);
		in.close();
	}

	public static void mainAux(String[] args) throws Exception {
		InputStream input = FlatlandSpaceStations.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "flatland_space_stations.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int citiesNumber = in.nextInt();
		int spaceStationsNumber = in.nextInt();
		List<Integer> minimunDistances = new ArrayList<Integer>();
		List<Integer> citiesWithSpaceStation = new ArrayList<Integer>(spaceStationsNumber);
		for (int i = 0; i < spaceStationsNumber; i++) {
			citiesWithSpaceStation.add(in.nextInt());
		}
		for (int i = 0; i < citiesNumber; i++) {
			minimunDistances.add(Integer.MAX_VALUE);
		}
		int maxDistance = Integer.MIN_VALUE;
		Collections.sort(citiesWithSpaceStation);
		for (int i = 0; i < citiesNumber; i++) {
			boolean foundMinimun = false;
			boolean exit = false;
			for (int j = 0; j < citiesWithSpaceStation.size() && !exit; j++) {
				int cityWithSpaceStation = citiesWithSpaceStation.get(j);
				int distance = Math.abs(i - cityWithSpaceStation);
				if (minimunDistances.get(i) == null || distance < minimunDistances.get(i)) {
					minimunDistances.set(i, distance);
					foundMinimun = true;
				} else {
					if (foundMinimun) {
						exit = true;
					}
				}
			}
			if (minimunDistances.get(i) > maxDistance) {
				maxDistance = minimunDistances.get(i);
			}
		}
		System.out.println(maxDistance);
		in.close();
	}
}
