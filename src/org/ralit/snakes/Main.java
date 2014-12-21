package org.ralit.snakes;

import static org.ralit.snakes.ImageUtility.rgb;
import static org.ralit.snakes.ImageUtility.writePoints;

import java.io.IOException;

public class Main {

	private static String HOME = System.getProperty("user.home");
	
	public static void main(String[] args) throws IOException {
		/**
		 * 1回だけ
		 */
//		int n = 1000;
//		float α = -4;
//		float β = 1;
//		float γ = 16;
//		Snakes snakes = new Snakes(
//				HOME + "/Desktop/Snakes/p388-nemu-yumemi.jpg", 
//				HOME + "/Desktop/Snakes/output/", 
//				HOME + "/Desktop/Snakes/data.txt", 
//				-1,
//				n, 
//				α, 
//				β, 
//				γ);
//		writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/p388-nemu-yumemi_"+"n"+n+","+α+","+β+","+γ+".png", rgb(255, 0, 0));

		/**
		 * たくさんパラメータを試す
		 */
		int n = 100;
		for(int α=0; α <= 100; α+=20) {
			for(int β=0; β <= 100; β+=20) {
				for(int γ=0; γ <= 100; γ+=20) {
					Snakes snakes = new Snakes(
							HOME + "/Desktop/Snakes/p388-nemu-yumemi.jpg", 
							HOME + "/Desktop/Snakes/output/", 
							HOME + "/Desktop/Snakes/data.txt", 
							-1,
							n, 
							α, 
							β, 
							γ);
					writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/p388-nemu-yumemi_"+"n"+n+","+α+","+β+","+γ+".png", rgb(255, 0, 0));
				}
			}
		}
		
//		int n = 100;
//		for(int α=0; α <= 100; α+=20) {
//			for(int β=0; β <= 100; β+=20) {
//				for(int γ=0; γ <= 100; γ+=20) {
//					Snakes snakes = new Snakes(
//							HOME + "/Desktop/Snakes/pusheen.jpg", 
//							HOME + "/Desktop/Snakes/output/", 
//							HOME + "/Desktop/Snakes/data.txt", 
//							-1,
//							n, 
//							α, 
//							β, 
//							γ);
//					writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/pusheen_"+"n"+n+","+α+","+β+","+γ+".png", rgb(255, 0, 0));
//				}
//			}
//		}

		System.out.println("おわり");
	}
	
	/**
	 * α, β, γの組合せが全く分からん
	 * 100, 20, 8 → うまくいかない
	 * 0.45, 0.35, 0.2 → うまくいかない
	 */

}


