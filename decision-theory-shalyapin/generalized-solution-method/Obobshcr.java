package obobshcr;

/**
 *
 * @author terehin.andrey
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Obobshcr {
	static void print_table(float[][] mas, int x, int y) {
		System.out.print("K\\U\t");
		for (int j = 0; j < y; j++)
			System.out.print(" U" + (j + 1) + "\t");
		System.out.println();

		for (int i = 0; i < x; i++) {
			System.out.print("K" + (i + 1) + "\t");
			for (int j = 0; j < y; j++)
				System.out.print(mas[i][j] + "\t");
			System.out.println();
		}
	}

	static boolean calculate(int N, int M, float[][] k, float[] a) {
		try {
			addictive_mas = new float[N];
			mult_mas = new double[N];
			for (int i = 0; i < N; i++)
				mult_mas[i] = 1;
			min_mas = new float[N];
			max_mas = new float[N];

			for (int i = 0; i < N; i++) {// по столбцам
				float tmp_min = (k[0][i] / a[0]);
				float tmp_max = (k[0][i] * a[0]);
				for (int j = 0; j < M; j++) {// по строкам
					addictive_mas[i] += a[j] * k[j][i];
					mult_mas[i] *= Math.pow(k[j][i], a[j]);
					if (j > 0) {
						if (tmp_min > (k[j][i] / a[j]))
							tmp_min = (k[j][i] / a[j]);
						if (tmp_max < (k[j][i] * a[j]))
							tmp_max = (k[j][i] * a[j]);
					}
				}
				min_mas[i] = tmp_min;
				max_mas[i] = tmp_max;
			}
			tmp_a = addictive_mas[0];
			tmp_mn = min_mas[0];
			tmp_mx = max_mas[0];
			tmp_M = mult_mas[0];
			return true;
		} catch (Exception e) {
			addictive_mas = null;
			mult_mas = null;
			min_mas = null;
			max_mas = null;
			tmp_a = 0;
			tmp_mn = 0;
			tmp_mx = 0;
			tmp_M = 0;
			return false;
		}
	}

	static double round(double value) {
		return round(value, 0);
	}

	static double round(double value, int precise) {
		return new BigDecimal(value).setScale(2, RoundingMode.UP).doubleValue();
	}

	static void print(int N, int M, String[] parameters_srt, float[] a, float[] addictive_mas, double[] mult_mas,
			float[] min_mas, float[] max_mas, float tmp_a, float tmp_mn, float tmp_mx, double tmp_M) {
		System.out.println("\nЗначимость критериев (K)");
		for (int i = 0; i < M; i++)
			System.out.println("K" + (i + 1) + " (" + parameters_srt[i] + ") \t" + Math.round(a[i] * 100) + "%");

		System.out.println("\nАддитивная свертка");
		for (int i = 0; i < N; i++)
			System.out.print(round(addictive_mas[i], 3) + "\t");
		System.out.println();
		System.out.print("Выбор:");
		for (int i = 0; i < N; i++)
			if (addictive_mas[i] == tmp_a)
				System.out.print(" квартира №" + (i + 1) + " ");
		System.out.println("\n");

		System.out.println("Мультипликативная свертка");
		for (int i = 0; i < N; i++)
			System.out.print(round(mult_mas[i], 3) + "\t");
		System.out.println();
		System.out.print("Выбор:");
		for (int i = 0; i < N; i++)
			if (mult_mas[i] == tmp_M)
				System.out.print(" квартира №" + (i + 1) + " ");
		System.out.println("\n");

		System.out.println("Свертка по минимуму");
		for (int i = 0; i < N; i++)
			System.out.print(round(min_mas[i], 3) + "\t");
		System.out.println();
		System.out.print("Выбор:");
		for (int i = 0; i < N; i++)
			if (min_mas[i] == tmp_mn)
				System.out.print(" квартира №" + (i + 1) + " ");
		System.out.println("\n");

		System.out.println("Свертка по максимуму");
		for (int i = 0; i < N; i++)
			System.out.print(round(max_mas[i], 3) + "\t");
		System.out.println();
		System.out.print("Выбор:");
		for (int i = 0; i < N; i++)
			if (max_mas[i] == tmp_mx)
				System.out.print(" квартира №" + (i + 1) + " ");
		System.out.println("\n");
	}

	static float[] addictive_mas;
	static double[] mult_mas;
	static float[] min_mas;
	static float[] max_mas;
	static float tmp_a, tmp_mn, tmp_mx;
	static double tmp_M;

	public static void main(String[] args) {
		// @formatter:off
		float[][] k = new float[][] { 
			{ 10, 4, 6, 9, 5,    3,   3, 3, 2 },
			{ 2,  7, 8, 2, 1,    8,   5, 6, 5 },
			{ 3,  3, 3, 3, .1f,  .1f, 4, 3, 3 },
			{ 2,  4, 5, 2, 5,    2,   2, 4, 1 }, 
			{ 2,  3, 4, 1, 2,    4,   7, 4, 5 },
			{ 4,  1, 2, 3, 2,    1,   7, 1, 7 } };
		// @formatter:on
		String[] parameters_srt = new String[] { "Общая площадь", "Площадь кухни", "Близость метро", "Качество дома",
				"Цена", "Этаж" };

		// float[] a = new float[] { 0.10f, 0.10f, .15f, .34f, .20f, .11f };
		 float[] a = new float[] { 0.2f, 0.1f, .08f, .1f, .5f, .02f };
		// float[] a = new float[] { .2f, .1f, .1f, .05f, .4f, .05f };

		calculate(9, 6, k, a);

		System.out.println("Выбор квартиры (U)");
		print_table(k, 6, 9);
		print(9, 6, parameters_srt, a, addictive_mas, mult_mas, min_mas, max_mas, tmp_a, tmp_mn, tmp_mx, tmp_M);
	}
}
