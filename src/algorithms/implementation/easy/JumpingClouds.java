package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JumpingClouds {

	
	private static final int ORDINARY_CLOUD = 0; 
	//private static final int THUNDER_CLOUD = 1; 
	
	public static void main(String[] args) throws IOException {
		InputStream input = JumpingClouds.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "jumping_clouds_02.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int cloudsNumber = in.nextInt();
		int[] clouds = new int[cloudsNumber];
		for (int i = 0; i < clouds.length; i++) {
			clouds[i] = in.nextInt();
		}
		int jumps = calculateJumps(clouds);
		System.out.println(jumps);
		in.close();
	}

	private static int calculateJumps(int[] clouds) {
		int index = 0;
		int jumps = 0;
		while(index<clouds.length -1) {
			if (index+2<clouds.length && clouds[index+2]==ORDINARY_CLOUD) {
				index += 2;				
			} else {		
				index++;
			}
			jumps++;
		}
		return jumps;
	}
}
