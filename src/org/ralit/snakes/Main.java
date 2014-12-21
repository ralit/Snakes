package org.ralit.snakes;

import static org.ralit.snakes.ImageUtility.rgb;
import static org.ralit.snakes.ImageUtility.writePoints;

import java.io.IOException;

public class Main {

	private static String HOME = System.getProperty("user.home");
	
	/**
	 * 1�񂾂�
	 */
	static int n = 100;
	static float �� = 0.45f;
	static float �� = 0.35f;
	static float �� = 0.2f;
	public static void main(String[] args) throws IOException {
		Snakes snakes = new Snakes(
				HOME + "/Desktop/Snakes/p388-nemu-yumemi.jpg", 
				HOME + "/Desktop/Snakes/output/", 
				HOME + "/Desktop/Snakes/data.txt", 
				-1,
				n, 
				��, 
				��, 
				��);
		writePoints(snakes.getImage().p, snakes.getPoints(), HOME + "/Desktop/Snakes/output/p388-nemu-yumemi_"+"n"+n+","+��+","+��+","+��+".png", rgb(255, 0, 0));

	/**
	 * ��������p�����[�^������
	 */
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


