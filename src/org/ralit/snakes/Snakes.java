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
	
	private float α;
	private float β;
	private float γ;
	private int[][] 移動方向配列 = {{-1,-1}, {0,-1}, {1,-1},
			                        {-1, 0},         {1, 0},
			                        {-1, 1}, {0, 1}, {1, 1}};
	private Image 入力画像;
	private Point[] v;
	
	public Snakes(String 入力画像パス, String 出力ディレクトリパス, String 初期頂点データパス, int 頂点の総移動量の閾値, int 繰り返し回数の上限, float α, float β, float γ) throws IOException {
		入力画像 = readFile(入力画像パス);
		this.α = α;
		this.β = β;
		this.γ = γ;

//		Image 初期頂点画像 = readFile(初期頂点画像パス);
//		v = get初期頂点配列(初期頂点画像);
//		for(int i = 0; i < v.length; i++) {
//			System.out.println(v[i]);
//		}
		
		v = 初期頂点データを読み込む(初期頂点データパス);
		
		Point[] v0 = new Point[v.length];
		for(int i = 0; i < v.length; i++) {
			v0[i] = v[i];
//			v0[i] = new Point();
//			v0[i].x = v[i].x;
//			v0[i].y = v[i].y;
		}
//		初期頂点画像 = null;
		int 頂点の総移動量 = 0;
		int 繰り返し回数 = 0;
		
		long time1 = System.currentTimeMillis();
		
//		while(繰り返し回数 < 繰り返し回数の上限 && 頂点の総移動量の閾値 < 頂点の総移動量) {
		while(繰り返し回数 < 繰り返し回数の上限) {
			繰り返し回数++;
			頂点の総移動量 = 0;
			for(int i = 0; i < v.length; i++) {
				int 移動方向 = i番目の頂点の8近傍の最小局所エネルギーを求める(i);
//				System.out.println(v[i].x + 移動方向配列[移動方向][0]);
//				System.out.println(v[i].x);
				v[i] = new Point(Math.min(Math.max(v[i].x + 移動方向配列[移動方向][0], 0), 入力画像.w - 1), Math.min(Math.max(v[i].y + 移動方向配列[移動方向][1], 0), 入力画像.h - 1));
//				v[i].x = Math.min(Math.max(v[i].x + 移動方向配列[移動方向][0], 0), 入力画像.w - 1);
//				v[i].y = Math.min(Math.max(v[i].y + 移動方向配列[移動方向][1], 0), 入力画像.h - 1);
				頂点の総移動量 += Math.pow((v[i].x - v0[i].x), 2) + Math.pow((v[i].y - v0[i].y), 2); 
			}
			System.out.println(繰り返し回数);
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
		return 入力画像;
	}
	
	private Point[] 初期頂点データを読み込む(String 初期頂点データパス) throws IOException {
		File file = new File(初期頂点データパス);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		ArrayList<Point> pointArrayList = new ArrayList<Point>();

		String line = reader.readLine();
		while(line != null) {
			String[] 頂点座標 = line.split(" ");
			pointArrayList.add(new Point(Integer.parseInt(頂点座標[0]), Integer.parseInt(頂点座標[1])));
			line = reader.readLine();
		}
		Point[] v = new Point[pointArrayList.size()];
		for (int i = 0; i < pointArrayList.size(); i++) {
			v[i] = pointArrayList.get(i);
		}
		return v;
	}
	
	private int i番目の頂点の8近傍の最小局所エネルギーを求める(int i) {
//		System.out.println("i番目の頂点の8近傍の最小局所エネルギーを求める");
		int 移動方向 = 0;
		double 最小値 = Double.MAX_VALUE;
		for(int j = 0; j < 移動方向配列.length; j++) {
			int x = Math.min(Math.max(v[i].x + 移動方向配列[j][0], 0), 入力画像.w - 1);
			int y = Math.min(Math.max(v[i].y + 移動方向配列[j][1], 0), 入力画像.h - 1);
			int 最小の8近傍の輝度 = 最小の8近傍の輝度(x, y);
			double 現在値 = α*( Math.pow((v[geti(i+1)].x - x), 2) + Math.pow((v[geti(i+1)].y - y), 2) ) +
			               β*( Math.pow(((v[geti(i+1)].x - x) + (v[geti(i-1)].x - x)), 2) + Math.pow(((v[geti(i+1)].y - y) + (v[geti(i-1)].y - y)), 2) ) + 
			               γ*( (-1f) * (入力画像.p[y][x] - 最小の8近傍の輝度) / Math.max(最大の8近傍の輝度(x, y) - 最小の8近傍の輝度, 5) );
//			System.out.println("現在値: " + 現在値);
			if(現在値 < 最小値) {
				最小値 = 現在値;
				移動方向 = j;
			}
		}
//		System.out.println("min: " + 最小値);
		return 移動方向;
	}
	
	private int 最大の8近傍の輝度(int x, int y) {
		int 最大値 = 0;
		for(int j = 0; j < 移動方向配列.length; j++) {
			int xx = Math.min(Math.max(x + 移動方向配列[j][0], 0), 入力画像.w - 1);
			int yy = Math.min(Math.max(y + 移動方向配列[j][1], 0), 入力画像.h - 1);
			int 現在値 = 入力画像.p[yy][xx];
			if(最大値 < 現在値) {
				最大値 = 現在値;
			}
		}
		return 最大値;
	}
	
	private int 最小の8近傍の輝度(int x, int y) {
		int 最小値 = Integer.MAX_VALUE;
		for(int j = 0; j < 移動方向配列.length; j++) {
			int xx = Math.min(Math.max(x + 移動方向配列[j][0], 0), 入力画像.w - 1);
			int yy = Math.min(Math.max(y + 移動方向配列[j][1], 0), 入力画像.h - 1);
			int 現在値 = 入力画像.p[yy][xx];
			if(現在値 < 最小値) {
				最小値 = 現在値;
			}
		}
		return 最小値;
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
	
	private Point[] get初期頂点配列(Image 初期頂点画像) {
		ArrayList<Point> pointArrayList = new ArrayList<Point>();
		for (int y = 0; y < 初期頂点画像.h; y++) {
			for (int x = 0; x < 初期頂点画像.w; x++) {
				if (初期頂点画像.p[y][x] < i2b(10)) { // 手持ちのペイントソフトで正確な黒(0)が書けなかったので10未満を黒としている
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
