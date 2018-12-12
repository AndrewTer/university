package pareto;

/**
 *
 * @author terehin.andrey
 */

import java.util.ArrayList;
import java.util.List;

public class Pareto {
	static void print_table(float[][] mas, int x, int y) {

		System.out.print("X\\R\t");
		for (int j = 0; j < y; j++)
			System.out.print(" R" + (j + 1) + "\t");
		System.out.println();

		for (int i = 0; i < x; i++) {
			System.out.print("X" + (i + 1) + "\t");
			for (int j = 0; j < y; j++)
				System.out.print(mas[i][j] + "\t");
			System.out.println();
		}
	}

	static List<Integer> pareto(float[][] massiv, int _rows, int _columns) {
		int c = 0;
		int cc = 0;
		int[] ud = new int[_columns];
		for (int i = 0; i < _columns; i++) {
			for (int j = 0; j < _columns; j++) {
				if (i == j)
					continue;
				c = 0;
				cc = 0;
				for (int l = 0; l < _rows; l++) {
					if (massiv[l][i] <= massiv[l][j]) {
						c++;
					} else if (massiv[l][i] > massiv[l][j]) {
						cc++;
					}
				}
				if (c == _rows) {
					ud[i] = 1;
				}
				if (cc == _rows) {
					ud[j] = 1;
				}
			}
		}
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < _columns; i++) {
			if (ud[i] == 0)
				myList.add(i + 1);
		}
		return myList;
	}

	public static void main(String[] args) {
		List<Integer> tmp;
		// @formatter:off
		float[][] k = new float[][] { 
			{ 10, 4, 6, 9, 5,    3,   3, 3, 2 },
			{ 2,  7, 8, 2, 1,    8,   5, 6, 5 },
			{ 3,  3, 3, 3, .1f, .1f, 4, 3, 3 }, 
			{ 2,  4, 5, 2, 5,    2,   2, 4, 1 }, 
			{ 2,  3, 4, 1, 2,    4,   7, 4, 5 },
			{ 4,  1, 2, 3, 2,    1,   7, 1, 7 } };

		print_table(k, 6, 9);
		tmp = pareto(k, 6, 9);
		System.out.print("\nМножество Парето(результат выбора): ");
		for (Integer i : tmp) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
}
