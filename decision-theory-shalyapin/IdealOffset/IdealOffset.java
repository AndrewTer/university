package idealoffset;
/**
 *
 * @author terehin.andrey
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <h1>Метод смещенного идеала</h1>
 * 
 * В общем случае алгоритм поиска наиболее предпочтительного объекта следующий:
 * <ol>
 * <li>формируется или уточняется идеальный объект;</li>
 * <li>анализируются объекты на соответствие идеальному объекту;</li>
 * <li>исключаются объекты, которые в результате анализа признаны заведомо не
 * наилучшими;</li>
 * <li>формируется идеальный объект уже на сокращенном множестве МКО и т.д Пока
 * не получим один или несколько наиболее предпочтительных объектов.</li>
 * </ol>
 * 
 *
 */
public class IdealOffset {

	/**
	 * Cтепень концентрации. Используется при подсчете матрицы L (см. метод
	 * {@link IdealOffset#doIdealOffset}).
	 */
	private final double[] P = new double[] { 1, 2, 3, 4, 5};

	/**
	 * Множество критериев
	 */
	CriteriaSet criteriaSet;

	/**
	 * Коэффициенты относительной важности (веса) критериев
	 */
	double[] arrayW;

	/**
	 * Флаг режима сохранения тишины. Если true то будем логировать все действия
	 * в консоли.
	 */
	private boolean keepSilent;

	public IdealOffset(CriteriaSet criteriaSet, double[] arrayW) {
		this(criteriaSet, arrayW, false);
	}

	/**
	 * 
	 * @param criteriaSet
	 * @param arrayW
	 * @param keepSilent
	 */
	public IdealOffset(CriteriaSet criteriaSet, double[] arrayW, boolean keepSilent) {
		this.criteriaSet = criteriaSet;
		this.arrayW = arrayW;

		this.keepSilent = keepSilent;

		doIdealOffset();
	}

	/**
	 * Применение метода смещенного идеала
	 */
	void doIdealOffset() {

		// в случае если в матрице критериев осталось только одна строка то
		// можно считать что это и есть решение. На этом и остановимся.
		if (criteriaSet.criteriaMatrix.getRows() < 2) {
			return;
		}

		if (!keepSilent) {
			System.out.println("Исходная матрица критериев (matrixK):");
			System.out.println(criteriaSet);
		}

		// подсчитываем матрицу D
		IndexedMatrix matrixD = new IndexedMatrix(criteriaSet.criteriaMatrix, false);
		for (int i = 0; i < criteriaSet.criteriaMatrix.getRows(); i++) {
			for (int j = 0; j < criteriaSet.criteriaMatrix.getColumns(); j++) {
				double best = criteriaSet.getBest(j);
				double worst = criteriaSet.getWorst(j);
				double value = (best - criteriaSet.criteriaMatrix.indexedValues[i][j].value) / (best - worst);
				matrixD.indexedValues[i][j].value = value;
			}
		}

		if (!keepSilent) {
			System.out.println("Матрица перехода по каждому критерию к относительным единицам измерения (matrixD):");
			System.out.println(matrixD);
		}

		// подсчитываем матрицу L
		IndexedMatrix matrixL = new IndexedMatrix(P.length, criteriaSet.criteriaMatrix.getRows());
		for (int k = 0; k < P.length; k++) {
			for (int i = 0; i < criteriaSet.criteriaMatrix.getRows(); i++) {
				double value = 0;
				for (int j = 0; j < criteriaSet.criteriaMatrix.getColumns(); j++) {
					value += (Math.pow((1 - matrixD.indexedValues[i][j].value) * arrayW[j], P[k]));
				}
				value = Math.pow(value, 1 / P[k]);
				matrixL.indexedValues[k][i] = new IndexedValue(matrixD.indexedValues[i][0].index, value);
			}
		}

		if (!keepSilent) {
			System.out.println("Матрица расстояний от объектов до идеального (matrixL):");
			System.out.println(matrixL);
		}

		// Для удобства сортируем матрицу L по значениям
		matrixL.sortByValue();

		if (!keepSilent) {
			System.out.println("Сортированная индексированная матрица расстояний от объектов до идеального (matrixL):");
			System.out.println(matrixL);
		}

		// И отфильтровываем не подходящие МКО
		filterBy(matrixL);

		if (!keepSilent) {
			System.out.println("Конец итерации ----------------------------------");
		}

		// будем вызываться в рекурсии пока кол-во строк в матрице критериев
		// criteriaSet.criteriaMatrix больше 1
		doIdealOffset();
	}

	/**
	 * <h1>Фильтрация исходной матрицы критериев {@link #criteriaSet} по входной
	 * матрице.</h1>
	 * 
	 * Сначала получаем номера МКО ({@link IndexedValue#index}), см метод
	 * {@link #getForRemove}, которые нужно исключить из матрицы критериев.
	 * 
	 * и собственно удаляем элементы с полученными индексами МКО (см.
	 * {@link #doFilter})
	 * 
	 * @param indexedMatrix
	 *            матрица, в зависимости от значений которой и происходит
	 *            фильтрация.
	 */
	void filterBy(IndexedMatrix indexedMatrix) {
		List<Integer> forRemove = getForRemove(indexedMatrix);
		doFilter(forRemove);
	}

	/**
	 * Получение индексов МКО подлежащих удалению из матрицы критериев.
	 * 
	 * Самое сложное. Так как иногда бывает весьма проблемо определить какие
	 * сбственно индексы подлежат удалению. В задании не говорится про то как
	 * обруливаются некоторые сложности.
	 * 
	 * Например: подлежат удалению те индексированные значения из матрицы
	 * критериев, индексы которых в матрице L после сортировки остались на
	 * первом месте (в этом примере сложностей нет):
	 * 
	 * 
	 * Сортированная индексированная матрица расстояний от объектов до идеального (matrixL):
	 * (1)5,600	(3)6,000	(0)6,067	(2)7,133	(5)7,667	(4)8,800
	 * (1)3,347	(0)4,705	(2)5,737	(3)6,000	(5)6,227	(4)6,248
	 * (1)2,866	(0)4,478	(4)5,589	(2)5,619	(3)6,000	(5)6,043
	 * (1)2,579	(0)4,407	(4)5,136	(2)5,601	(3)6,000	(5)6,002
	 * (1)2,465	(0)4,400	(4)4,927	(2)5,600	(3)6,000	(5)6,000
	 * 
	 * 
	 * В данном случае удалению подлежит удалению индекс 1. Тут все норм, ясно и
	 * понятно.
	 * 
	 * НО в другом случае уже сложнее определить индекс подлежащий удалению.
	 * Поэтому сейчас принимается решение удалить те индексированные значения
	 * чей индекс чаще встречался в первых двух столбцах отсортированной матрицы
	 * L. Например:
	 * 
	 * 
	 * Сортированная индексированная матрица расстояний от объектов до идеального (matrixL):
	 * (3)6,000	(5)8,000	(4)8,800	
	 * (3)6,000	(4)6,248	(5)6,325	
	 * (4)5,589	(3)6,000	(5)6,073	
	 * (4)5,136	(3)6,000	(5)6,005	
	 * (4)4,927	(3)6,000	(5)6,000
	 * 
	 * 
	 * Поэтому тут удаляем 3.
	 * 
	 * 
	 * Сортированная индексированная матрица расстояний от объектов до идеального (matrixL):
	 * (3)12,000	(0)16,667	(1)17,000	(2)17,667
	 * (2)11,949	(3)12,000	(0)12,019	(1)13,000
	 * (0)10,904	(2)11,043	(3)12,000	(1)12,283
	 * (0)10,251	(2)10,715	(3)12,000	(1)12,030
	 * (0)10,048	(2)10,670	(3)12,000	(1)12,001
	 * 
	 * 
	 * А вот здесь уже будем удалять 2 и 0 не смотря на то, что индекс 2
	 * присутствует в 4-том столюце а индекс 0 в 3-ем, так как они чаще всего
	 * встречаются в двух первых столбцах.
	 * 
	 * @param indexedMatrix
	 * @return
	 */
	public List<Integer> getForRemove(IndexedMatrix indexedMatrix) {
		List<Integer> forRemove = new ArrayList<>();

		int[] columns = indexedMatrix.getColumns() > 2 ? new int[] { 0, 1 } : new int[] { 0 };
		int maxCount = 0;

		Map<Integer, Integer> indexCountMap = new HashMap<>();
		for (int j = 0; j < columns.length; j++) {
			for (int i = 0; i < indexedMatrix.getRows(); i++) {

				int column = columns[j];

				if (indexCountMap.containsKey(indexedMatrix.indexedValues[i][column].index)) {
					int count = indexCountMap.get(indexedMatrix.indexedValues[i][column].index);
					count++;
					if (maxCount < count) {
						maxCount = count;
					}
					indexCountMap.put(indexedMatrix.indexedValues[i][column].index, count);
				} else {
					indexCountMap.put(indexedMatrix.indexedValues[i][column].index, 1);
				}
			}
		}

		for (Entry<Integer, Integer> entry : indexCountMap.entrySet()) {
			if (entry.getValue() == indexedMatrix.getRows()) {
				forRemove.add(entry.getKey());
			}
		}

		if (forRemove.isEmpty()) {
			for (Entry<Integer, Integer> entry : indexCountMap.entrySet()) {
				if (entry.getValue() == maxCount) {
					forRemove.add(entry.getKey());
				}
			}
		}

		if (!keepSilent) {
			System.out.println("Индексы для удаления (forRemove): " + Arrays.toString(forRemove.toArray()));
		}

		return forRemove;
	}

	/**
	 * Удаление из матрицы значений с идексами
	 * 
	 * @param forRemove
	 *            индексы подлежащие удалению
	 */
	void doFilter(List<Integer> forRemove) {
		for (Integer i : forRemove) {
			criteriaSet.criteriaMatrix.removeByIndex(i);
		}

		if (!keepSilent) {
			System.out.println("Матрица критериев после удаления строк (matrixK):");
			System.out.println(criteriaSet.criteriaMatrix);
		}
	}

	@Override
	public String toString() {
		return "Решение: \n" + criteriaSet.criteriaMatrix.toString();
	}

	/**
	 * Индексированное значение. Необходимо для того что бы знать к какому МКО
	 * принадлежит данное значение. {@link IndexedValue#index} номер МКО к
	 * которому принадлежит, собственно, значение {@link IndexedValue#value}
	 */
	static class IndexedValue {

		/**
		 * Индекс. Номер МКО.
		 */
		int index;

		/**
		 * Значение
		 */
		double value;

		public IndexedValue(int index) {
			super();
			this.index = index;
		}

		public IndexedValue(int index, double value) {
			super();
			this.index = index;
			this.value = value;
		}

		@Override
		public String toString() {
                    int indexx = index +1;
			return "(" + (indexx) + ")" + String.format("%.3f", value);
		}
	}

	/**
	 * <h1>Матрица индексированных значений.</h1>
	 * 
	 * Создана для того что бы была возможность удаления из матрицы значений по
	 * индексу ({@link IndexedValue#index}) см. метод
	 * {@link IndexedMatrix#removeByIndex}.
	 * 
	 */
	static class IndexedMatrix {

		/**
		 * Двумерный массив индексированных значений. Собственно, матрица.
		 */
		IndexedValue[][] indexedValues;

		/**
		 * Компаратов индексированных значений. Сортировка по
		 * {@link IndexedValue#value} от меньшего к большему
		 */
		private static final Comparator<IndexedValue> BY_VALUE_COMPARATOR = new Comparator<IdealOffset.IndexedValue>() {
			@Override
			public int compare(IndexedValue iv1, IndexedValue iv2) {
				return iv1.value < iv2.value ? -1 : iv1.value == iv2.value ? 0 : 1;
			}
		};

		public IndexedMatrix(double[][] matrix) {
			this(matrix, true);
		}

		/**
		 * 
		 * @param matrix
		 *            матрица значений
		 * @param indexByRows
		 *            направление индексации значений. Если true, то компоненты
		 *            каждой строки будут принадлежать только одному МКО Если
		 *            false то компоненты каждого стобца будут принадлежать
		 *            только одному МКО
		 */
		public IndexedMatrix(double[][] matrix, boolean indexByRows) {
			indexedValues = new IndexedValue[matrix.length][matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					indexedValues[i][j] = new IndexedValue(indexByRows ? i : j, matrix[i][j]);
				}
			}
		}

		public IndexedMatrix(IndexedMatrix matrix, boolean transpose) {
			indexedValues = transpose ? new IndexedValue[matrix.getColumns()][matrix.getRows()]
					: new IndexedValue[matrix.getRows()][matrix.getColumns()];
			for (int i = 0; i < matrix.getRows(); i++) {
				for (int j = 0; j < matrix.getColumns(); j++) {
					indexedValues[i][j] = new IndexedValue(matrix.indexedValues[i][j].index);
				}
			}
		}

		public IndexedMatrix(IndexedValue[][] indexedValues) {
			super();
			this.indexedValues = indexedValues;
		}

		public IndexedMatrix(int rows, int columns) {
			indexedValues = new IndexedValue[rows][columns];
		}

		/**
		 * Сортировка строк матрицы по значению (см.
		 * {@link IdealOffset.IndexedMatrix#BY_VALUE_COMPARATOR})
		 */
		void sortByValue() {
			for (IndexedValue[] row : indexedValues) {
				Arrays.sort(row, BY_VALUE_COMPARATOR);
			}
		}

		/**
		 * Удаление строки матрицы
		 * 
		 * @param i
		 */
		private void removeRow(int i) {
			IndexedValue[][] newArray = new IndexedValue[indexedValues.length - 1][getColumns()];
			System.arraycopy(indexedValues, 0, newArray, 0, i);
			System.arraycopy(indexedValues, i + 1, newArray, i, indexedValues.length - i - 1);
			indexedValues = newArray;
		}

		/**
		 * Удаление элемента
		 * 
		 * @param i
		 * @param j
		 */
		private void removeElement(int i, int j) {
			IndexedValue[] newRow = new IndexedValue[indexedValues[i].length - 1];
			System.arraycopy(indexedValues[i], 0, newRow, 0, j);
			System.arraycopy(indexedValues[i], j + 1, newRow, j, indexedValues[i].length - j - 1);
			indexedValues[i] = newRow;
		}

		/**
		 * <h1>Удаление элементов по индексу.</h1>
		 * 
		 * Удаляются все элементы из матрицы с данным индексом (
		 * {@link IndexedValue#index}). Удаление в основном происходит либо
		 * целой строки (в этом случает помимо
		 * {@link IndexedMatrix#removeElement} происходит
		 * {@link IndexedMatrix#removeRow}), либо столбца (тут уже просто на
		 * каждой строке дергается метод {@link IndexedMatrix#removeElement}).
		 * 
		 * @param index
		 */
		void removeByIndex(int index) {
			int i = 0;
			while (i < getRows()) {
				int j = 0;
				while (j < getColumns() && indexedValues[i].length != 0) {
					if (indexedValues[i][j].index == index) {
						removeElement(i, j);
						continue;
					}
					j++;
				}
				if (indexedValues[i].length == 0) {
					removeRow(i);
					continue;
				}
				i++;
			}
		}

		int getRows() {
			return indexedValues.length;
		}

		int getColumns() {
			return indexedValues[0].length;
		}

		@Override
		public String toString() {
			return  ArrayUtils.toString(indexedValues);
		}
	}

	/**
	 * Множество критериев. Смысл класса в {@link CriteriaSet#getBest} и
	 * {@link CriteriaSet#getWorst}
	 */
	static abstract class CriteriaSet {

		/**
		 * Матрица критериев множетва МКО
		 */
		IndexedMatrix criteriaMatrix;

		public CriteriaSet(double[][] matrixK) {
			this.criteriaMatrix = new IndexedMatrix(matrixK);
		}

		/**
		 * Получение наилучшего элемента из столбца
		 * 
		 * @param column
		 *            номер столбца
		 * @return
		 */
		abstract double getBest(int column);

		/**
		 * Получение наихудшего элемента из столбца
		 * 
		 * @param column
		 *            номер столбца
		 * @return
		 */
		abstract double getWorst(int column);

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			result.append(criteriaMatrix);

			result.append("Best: ");
			for (int i = 0; i < criteriaMatrix.getColumns(); i++) {
				result.append(getBest(i) + "\t");
			}
			result.append("\nWorst: ");
			for (int i = 0; i < criteriaMatrix.getColumns(); i++) {
				result.append(getWorst(i) + "\t");
			}
			result.append("\n");
			return result.toString();
		}
	}

	public static void main(String[] args) {
		// @formatter:off
		double[][] k = new double[][] { 
			{ 5.0,  1.0, 50.0  }, 
			{ 10.0, 1.5, 40.0  },
			{ 2.0,  1.5, 90.0  },
			{ 1.0,  1.0, 100.0 }, 
			{ 6.0,  3.0, 100.0 },
			{ 16.0, 3.5, 50.0  }};
		// @formatter:on

		double[] arrayW;

		arrayW = new double[] { 6, 6, 2 };
		//arrayW = new double[] { 12, 5, 12 };
		//arrayW = new double[] { 5, 1, 1 };
		//arrayW = new double[] { 1, 5, 4 };

		CriteriaSet criteriaSet = new CriteriaSet(k) {

			@Override
			double getBest(int column) {
				switch (column) {
				case 0:
					return ArrayUtils.getMinValueInColumn(criteriaMatrix.indexedValues, 0);
				case 1:
					return ArrayUtils.getMaxValueInColumn(criteriaMatrix.indexedValues, 1);
				case 2:
					return ArrayUtils.getMinValueInColumn(criteriaMatrix.indexedValues, 2);
				default:
					throw new ArrayIndexOutOfBoundsException();
				}
			}

			@Override
			double getWorst(int column) {
				switch (column) {
				case 0:
					return ArrayUtils.getMaxValueInColumn(criteriaMatrix.indexedValues, 0);
				case 1:
					return ArrayUtils.getMinValueInColumn(criteriaMatrix.indexedValues, 1);
				case 2:
					return ArrayUtils.getMaxValueInColumn(criteriaMatrix.indexedValues, 2);
				default:
					throw new ArrayIndexOutOfBoundsException();
				}
			}
		};

		System.out.println(new IdealOffset(criteriaSet, arrayW, true));
	}

}
