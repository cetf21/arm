package test3;

import java.util.Scanner;

public class Shujunihe {
	int n = 9;// 9条数据
	int m = 2;// x的维数
	int cnt = 0;
	double a[][] = new double[m + 1][m + 1];
	double b[] = new double[m + 1];
	int x1[] = new int[a.length];
	int y1[] = new int[a.length];
	int x2[] = { 1, 2, 3 };// 用来存放交换后变量x的位置
	boolean fyl;
	int xlh;
	double x[] = { 1, 3, 4, 5, 6, 7, 8, 9, 10 };
	double f[] = { 10, 5, 4, 2, 1, 1, 2, 3, 4 };
	double c[] = { 1, 2, 3 };

	public void printarray(double a[][]) {
		for (int row = 0; row < a.length; row++) {
			for (int c = 0; c < a[row].length; c++) {
				System.out.print(" " + a[row][c]);

			}
			System.out.println();
		}

	}

	public Shujunihe() {
		restoreA();
		restoreB();
		quanzhuyuan(a, b);
		printarray(a);
	}

	public void quanzhuyuan(double d[][], double c[])

	{
		double max;
		int row, col;
		double temp1, temp2;
		int temp3;
		double btemp1;
		for (int i = 0; i < d.length; i++) {

			max = Math.abs(d[i][i]);

			row = i;
			col = i;
			for (int j = i; j < d.length; j++) {
				for (int k = i; k < d.length; k++) {
					if (Math.abs(d[j][k]) > max) {
						max = Math.abs(d[j][k]);
						row = j;
						col = k;
					}
				}
			}
			/*
			 * for(int n=0;n<d.length;n++)//hang
			 * 
			 * { temp1=a[i][n]; a[i][n]=a[row][n]; a[row][n]=temp1; btemp1=b[i];
			 * b[i]=b[row]; b[row]=btemp1; } for(int m=0;m<d.length;m++)//lie {
			 * temp2=a[m][i]; a[m][i]=a[m][col]; a[m][col]=temp2; }
			 */
			if (col != i && row != i) {
				fyl = true;
				xlh = col;
				for (int n = 0; n < d.length; n++)// hang
				{
					temp1 = a[i][n];

					a[i][n] = a[row][n];

					a[row][n] = temp1;
					btemp1 = b[i];
					b[i] = b[row];
					b[row] = btemp1;
				}
				for (int m = 0; m < d.length; m++)// lie
				{
					temp2 = a[m][i];
					a[m][i] = a[m][col];
					a[m][col] = temp2;

				}
			} else if (row != i && col == i) {
				for (int n = 0; n < d.length; n++)// hang
				{
					temp1 = a[i][n];
					a[i][n] = a[row][n];
					a[row][n] = temp1;
					btemp1 = b[i];
					b[i] = b[row];
					b[row] = btemp1;
				}
			} else if (col != i && row == i)

			{
				fyl = true;
				for (int m = 0; m < d.length; m++)// lie
				{
					xlh = col;
					temp2 = a[m][i];
					a[m][i] = a[m][col];
					a[m][col] = temp2;
				}
			}

			if (fyl) {
				temp3 = x2[i];
				x2[i] = x2[xlh];
				x2[xlh] = temp3;
				x1[cnt] = i;
				y1[cnt] = xlh;
				cnt++;
				fyl = false;
			}
			for (int j = i + 1; j < d.length; j++)// J表示行
			{
				double l = a[j][i] / a[i][i];

				for (int e = i + 1; e < d.length; e++)// e表示j行对于的每一列
				{
					a[j][e] = a[j][e] - l * a[i][e];
				}
				b[j] = b[j] - l * b[i];

				a[j][i] = 0;
			}
		}
	}

	public void restoreA() {
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= m; j++) {
				a[i][j] = Sum(i, j);
			}
		}
		a[0][0] = n;
	}

	public double Sum(int r, int c) {
		double sum = 0;
		for (int i = 0; i <= n - 1; i++) {
			sum += Math.pow(x[i], r + c);
		}
		return sum;
	}

	public double Sumf(int r) {
		double sum = 0;
		for (int i = 0; i <= n - 1; i++) {
			sum += f[i] * Math.pow(x[i], r);
		}
		return sum;
	}

	public void restoreB() {
		for (int i = 0; i <= m; i++) {
			b[i] = Sumf(i);
		}
	}

	public static void main(String[] args) { // TODO Auto-generated method stub
												
		 new Shujunihe();
	}
}
