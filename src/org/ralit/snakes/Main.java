package org.ralit.snakes;

import static org.ralit.snakes.ImageUtility.rgb;
import static org.ralit.snakes.ImageUtility.writePoints;

import java.io.IOException;

public class Main {

	private static String HOME = System.getProperty("user.home");
	
	/**
	 * 1回だけ
	 */
	static int n = 100;
	static float α = 0.45f;
	static float β = 0.35f;
	static float γ = 0.2f;
	public static void main(String[] args) throws IOException {
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

	/**
	 * たくさんパラメータを試す
	 */
//		int n = 100;
//		for(int α=1; α <= 10; α+=3) {
//			for(int β=1; β <= 10; β+=3) {
//				for(int γ=1; γ <= 10; γ+=3) {
//					Snakes snakes = new Snakes(
//							HOME + "/Desktop/Snakes/p388-nemu-yumemi.jpg", 
//							HOME + "/Desktop/Snakes/output/", 
//							HOME + "/Desktop/Snakes/data.txt", 
//							-1,
//							n, 
//							α, 
//							β, 
//							γ);
//					writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/p388-nemu-yumemi_"+"n"+n+","+α+","+β+","+γ+".png", rgb(255, 0, 0));
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


