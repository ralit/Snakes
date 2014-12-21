package org.ralit.snakes;

import static org.ralit.snakes.ImageUtility.i2b;
import static org.ralit.snakes.ImageUtility.rgb2ycbcr;
import static org.ralit.snakes.ImageUtility.y;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Snakes {
	
	private float ��;
	private float ��;
	private float ��;
	private int[][] �ړ������z�� = {{-1,-1}, {0,-1}, {1,-1},
			                        {-1, 0},         {1, 0},
			                        {-1, 1}, {0, 1}, {1, 1}};
	private Image ���͉摜;
	private Point[] v;
	
	public Snakes(String ���͉摜�p�X, String �o�̓f�B���N�g���p�X, String �������_�f�[�^�p�X, int ���_�̑��ړ��ʂ�臒l, int �J��Ԃ��񐔂̏��, float ��, float ��, float ��) throws IOException {
		���͉摜 = readFile(���͉摜�p�X);
		this.�� = ��;
		this.�� = ��;
		this.�� = ��;

//		Image �������_�摜 = readFile(�������_�摜�p�X);
//		v = get�������_�z��(�������_�摜);
//		for(int i = 0; i < v.length; i++) {
//			System.out.println(v[i]);
//		}
		
		v = �������_�f�[�^��ǂݍ���(�������_�f�[�^�p�X);
		
		Point[] v0 = new Point[v.length];
		for(int i = 0; i < v.length; i++) {
			v0[i] = v[i];
//			v0[i] = new Point();
//			v0[i].x = v[i].x;
//			v0[i].y = v[i].y;
		}
//		�������_�摜 = null;
		int ���_�̑��ړ��� = 0;
		int �J��Ԃ��� = 0;
		
		long time1 = System.currentTimeMillis();
		
//		while(�J��Ԃ��� < �J��Ԃ��񐔂̏�� && ���_�̑��ړ��ʂ�臒l < ���_�̑��ړ���) {
		while(�J��Ԃ��� < �J��Ԃ��񐔂̏��) {
			�J��Ԃ���++;
			���_�̑��ړ��� = 0;
			for(int i = 0; i < v.length; i++) {
				int �ړ����� = i�Ԗڂ̒��_��8�ߖT�̍ŏ��Ǐ��G�l���M�[�����߂�(i);
//				System.out.println(v[i].x + �ړ������z��[�ړ�����][0]);
//				System.out.println(v[i].x);
				v[i] = new Point(Math.min(Math.max(v[i].x + �ړ������z��[�ړ�����][0], 0), ���͉摜.w - 1), Math.min(Math.max(v[i].y + �ړ������z��[�ړ�����][1], 0), ���͉摜.h - 1));
//				v[i].x = Math.min(Math.max(v[i].x + �ړ������z��[�ړ�����][0], 0), ���͉摜.w - 1);
//				v[i].y = Math.min(Math.max(v[i].y + �ړ������z��[�ړ�����][1], 0), ���͉摜.h - 1);
				���_�̑��ړ��� += Math.pow((v[i].x - v0[i].x), 2) + Math.pow((v[i].y - v0[i].y), 2); 
			}
			System.out.println(�J��Ԃ���);
		}
		
		for(int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
			System.out.println(v0[i]);
		}
				
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1 + " ms");
	}
	
	public Point[] getPoints() {
		return v;
	}
	
	public Image getImage() {
		return ���͉摜;
	}
	
	private Point[] �������_�f�[�^��ǂݍ���(String �������_�f�[�^�p�X) throws IOException {
		File file = new File(�������_�f�[�^�p�X);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		ArrayList<Point> pointArrayList = new ArrayList<Point>();

		String line = reader.readLine();
		while(line != null) {
			String[] ���_���W = line.split(" ");
			pointArrayList.add(new Point(Integer.parseInt(���_���W[0]), Integer.parseInt(���_���W[1])));
			line = reader.readLine();
		}
		Point[] v = new Point[pointArrayList.size()];
		for (int i = 0; i < pointArrayList.size(); i++) {
			v[i] = pointArrayList.get(i);
		}
		return v;
	}
	
	private int i�Ԗڂ̒��_��8�ߖT�̍ŏ��Ǐ��G�l���M�[�����߂�(int i) {
//		System.out.println("i�Ԗڂ̒��_��8�ߖT�̍ŏ��Ǐ��G�l���M�[�����߂�");
		int �ړ����� = 0;
		double �ŏ��l = Double.MAX_VALUE;
		for(int j = 0; j < �ړ������z��.length; j++) {
			int x = Math.min(Math.max(v[i].x + �ړ������z��[j][0], 0), ���͉摜.w - 1);
			int y = Math.min(Math.max(v[i].y + �ړ������z��[j][1], 0), ���͉摜.h - 1);
			int �ŏ���8�ߖT�̋P�x = �ŏ���8�ߖT�̋P�x(x, y);
			double ���ݒl = ��*( Math.pow((v[geti(i+1)].x - x), 2) + Math.pow((v[geti(i+1)].y - y), 2) ) +
			               ��*( Math.pow(((v[geti(i+1)].x - x) + (v[geti(i-1)].x - x)), 2) + Math.pow(((v[geti(i+1)].y - y) + (v[geti(i-1)].y - y)), 2) ) + 
			               ��*( (-1f) * (���͉摜.p[y][x] - �ŏ���8�ߖT�̋P�x) / Math.max(�ő��8�ߖT�̋P�x(x, y) - �ŏ���8�ߖT�̋P�x, 5) );
//			System.out.println("���ݒl: " + ���ݒl);
			if(���ݒl < �ŏ��l) {
				�ŏ��l = ���ݒl;
				�ړ����� = j;
			}
		}
//		System.out.println("min: " + �ŏ��l);
		return �ړ�����;
	}
	
	private int �ő��8�ߖT�̋P�x(int x, int y) {
		int �ő�l = 0;
		for(int j = 0; j < �ړ������z��.length; j++) {
			int xx = Math.min(Math.max(x + �ړ������z��[j][0], 0), ���͉摜.w - 1);
			int yy = Math.min(Math.max(y + �ړ������z��[j][1], 0), ���͉摜.h - 1);
			int ���ݒl = ���͉摜.p[yy][xx];
			if(�ő�l < ���ݒl) {
				�ő�l = ���ݒl;
			}
		}
		return �ő�l;
	}
	
	private int �ŏ���8�ߖT�̋P�x(int x, int y) {
		int �ŏ��l = Integer.MAX_VALUE;
		for(int j = 0; j < �ړ������z��.length; j++) {
			int xx = Math.min(Math.max(x + �ړ������z��[j][0], 0), ���͉摜.w - 1);
			int yy = Math.min(Math.max(y + �ړ������z��[j][1], 0), ���͉摜.h - 1);
			int ���ݒl = ���͉摜.p[yy][xx];
			if(���ݒl < �ŏ��l) {
				�ŏ��l = ���ݒl;
			}
		}
		return �ŏ��l;
	}
	
	private int geti(int i) {
		if(i < 0) {
			return v.length - 1;
		} else if(v.length - 1 < i) {
			return 0;
		} else {
			return i;
		}
	}
	
	private Point[] get�������_�z��(Image �������_�摜) {
		ArrayList<Point> pointArrayList = new ArrayList<Point>();
		for (int y = 0; y < �������_�摜.h; y++) {
			for (int x = 0; x < �������_�摜.w; x++) {
				if (�������_�摜.p[y][x] < i2b(10)) { // �莝���̃y�C���g�\�t�g�Ő��m�ȍ�(0)�������Ȃ������̂�10���������Ƃ��Ă���
					pointArrayList.add(new Point(x, y));
				}
			}
		}
		Point[] v = new Point[pointArrayList.size()];
		for (int i = 0; i < pointArrayList.size(); i++) {
			v[i] = pointArrayList.get(i);
		}
		pointArrayList = null;
		return v;
	}
	
	private Image readFile(String file) throws IOException {
		BufferedImage read = ImageIO.read(new File(file));
		int w = read.getWidth();
		int h = read.getHeight();
		byte[][] gray = new byte[h][w];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				gray[y][x] = i2b(y(rgb2ycbcr(read.getRGB(x, y))));
			}
		}
		read = null;
		return new Image(w, h, gray);
	}
	

}
