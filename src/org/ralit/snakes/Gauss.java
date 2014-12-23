package org.ralit.snakes;

/**
 * http://www.geocities.jp/java_sample_program/GaussNoSyoukyoHou.html
 */
class Gauss {

	private double[][] a;
	private int N;
	private double[] x;
	
	public Gauss(double[][] a_) {
		a = a_;
		N = a.length;
		x = new double [N];
	}

	public double[] getSolution() {
		for(int k=0;k<N;k++){
			pivot(N, k, a);
			forward(N, k, a);
		}
		backward(N, a, x);
		return x;
	}
	     
	private void pivot(int N,int k,double a[][]){
		int ip;
		double max;
		max=Math.abs(a[k][k]);
		ip=k;
		if(k != N-1){
			for(int i=k+1 ; i<N ; i++){
				if(Math.abs(a[i][k]) > max){
					max=Math.abs(a[i][k]);
					ip=i;
				}
			}
		}
		if(ip != k){
			for(int j=k ; j<=N ; j++){
				double copy=a[k][j];
				a[k][j]=a[ip][j];
				a[ip][j]=copy;
			}
		}
	}

	private void forward(int N,int k,double a[][]){
		double p,q;
		p=a[k][k];
		for(int j=k;j<=N;j++)
			a[k][j]/=p;
		if( k != N-1){
			for(int i=k+1;i<N;i++){
				q=a[i][k];
				for(int l=k+1;l<=N;l++)
					a[i][l]-=q*a[k][l];
			}
		}
	}

	private void backward(int N,double a[][],double x[]){
		x[N-1]=a[N-1][N]/a[N-1][N-1];
		for(int k=N-2;k>=0;k--){
			double sum=0.0;
			for(int j=k+1;j<N;j++)
				sum += a[k][j]*x[j];
			x[k]=a[k][N]-sum;
		}
	}
}