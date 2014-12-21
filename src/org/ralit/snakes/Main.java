package org.ralit.snakes;

import static org.ralit.snakes.ImageUtility.rgb;
import static org.ralit.snakes.ImageUtility.writePoints;

import java.io.IOException;

public class Main {

	private static String HOME = System.getProperty("user.home");
	
	public static void main(String[] args) throws IOException {
		Snakes snakes = new Snakes(
				HOME + "/Desktop/Snakes/p388-nemu-yumemi.jpg", 
				HOME + "/Desktop/Snakes/output/", 
				HOME + "/Desktop/Snakes/data.txt", 
				-1,
				100, 
				0.45f, 
				0.35f, 
				0.2f);
		writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/p388-nemu-yumemi_045,035,02.png", rgb(255, 0, 0));

		
//		int n = 100;
//		for(int ƒ¿=1; ƒ¿ <= 10; ƒ¿+=3) {
//			for(int ƒÀ=1; ƒÀ <= 10; ƒÀ+=3) {
//				for(int ƒÁ=1; ƒÁ <= 10; ƒÁ+=3) {
//					Snakes snakes = new Snakes(
//							HOME + "/Desktop/Snakes/p388-nemu-yumemi.jpg", 
//							HOME + "/Desktop/Snakes/output/", 
//							HOME + "/Desktop/Snakes/data.txt", 
//							-1,
//							n, 
//							ƒ¿, 
//							ƒÀ, 
//							ƒÁ);
//					writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/p388-nemu-yumemi_"+"n"+n+","+ƒ¿+","+ƒÀ+","+ƒÁ+".png", rgb(255, 0, 0));
//				}
//			}
//		}

		System.out.println("‚¨‚í‚è");
	}
	
	/**
	 * ƒ¿, ƒÀ, ƒÁ‚Ì‘g‡‚¹‚ª‘S‚­•ª‚©‚ç‚ñ
	 * 100, 20, 8 ¨ ‚¤‚Ü‚­‚¢‚©‚È‚¢
	 * 0.45, 0.35, 0.2 ¨ ‚¤‚Ü‚­‚¢‚©‚È‚¢
	 */

}


