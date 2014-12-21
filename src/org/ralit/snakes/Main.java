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
//		for(int ��=1; �� <= 10; ��+=3) {
//			for(int ��=1; �� <= 10; ��+=3) {
//				for(int ��=1; �� <= 10; ��+=3) {
//					Snakes snakes = new Snakes(
//							HOME + "/Desktop/Snakes/p388-nemu-yumemi.jpg", 
//							HOME + "/Desktop/Snakes/output/", 
//							HOME + "/Desktop/Snakes/data.txt", 
//							-1,
//							n, 
//							��, 
//							��, 
//							��);
//					writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/p388-nemu-yumemi_"+"n"+n+","+��+","+��+","+��+".png", rgb(255, 0, 0));
//				}
//			}
//		}

		System.out.println("�����");
	}
	
	/**
	 * ��, ��, ���̑g�������S���������
	 * 100, 20, 8 �� ���܂������Ȃ�
	 * 0.45, 0.35, 0.2 �� ���܂������Ȃ�
	 */

}


