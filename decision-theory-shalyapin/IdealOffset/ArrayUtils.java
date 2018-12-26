package idealoffset;

import idealoffset.IdealOffset.IndexedValue;

class ArrayUtils {

	static String toString(int[] array) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			result.append(array[i]);
			result.append("\t");
		}
		return result.toString();
	}

	static String toString(double[][] array) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			result.append(toString(array[i]));
			result.append("\n");
		}
		return result.toString();
	}

	static String toString(double[] array) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			result.append(String.format("%.3f", array[i]));
			result.append("\t");
		}
		return result.toString();
	}

	static <T> String toString(T[][] array) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			result.append(toString(array[i]));
			result.append("\n");
		}
		return result.toString();
	}

	static <T> String toString(T[] array) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			result.append(array[i]);
			result.append("\t");
		}
		return result.toString();
	}

	public static double getMinValueInColumn(IndexedValue[][] array, int column) {
		int min = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[min][column].value > array[i][column].value) {
				min = i;
			}
		}
		return array[min][column].value;
	}

	public static double getMaxValueInColumn(IndexedValue[][] array, int column) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[max][column].value < array[i][column].value) {
				max = i;
			}
		}
		return array[max][column].value;
	}

	public static double getMinValueInColumn(double[][] array, int column) {
		int min = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[min][column] > array[i][column]) {
				min = i;
			}
		}
		return array[min][column];
	}

	public static double getMaxValueInColumn(double[][] array, int column) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[max][column] < array[i][column]) {
				max = i;
			}
		}
		return array[max][column];
	}

}