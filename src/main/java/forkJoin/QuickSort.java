package forkJoin;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by APandey on 18-04-2017.
 */
public class QuickSort<T extends Comparable> {
	private List<T> data;
	private int left;
	private int right;

	public QuickSort(List<T> data) {
		this.data = data;
		this.left = 0;
		this.right = data.size() -1;
	}

	public QuickSort(List<T> data, int left, int right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	private void swap(int i, int j) {
		if(i != j) {
			T tempVal = data.get(i);
			data.set(i, data.get(j));
			data.set(j, tempVal);
		}
	}

	private int partition(int pivotIndex) {
		T pivotValue = data.get(pivotIndex);
		swap(pivotIndex, right);
		int storeIndex = left;
		return 0;
	}
}
