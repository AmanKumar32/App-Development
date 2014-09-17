package com.aman.calculatorapp;

public class SortingCalculator {

	public static int[] duplicateArray(int x) {
		int[] source = new int[x];
		for (int i = 0; i < x; i++) {
			int rnd = (int) (Math.random() * 52);
			source[i] = rnd;
		}
		return source;
	}

	public static int[] doInsertionSort(int[] source) {

		int temp = 0;
		for (int i = 1; i < source.length; i++) {
			for (int j = i; j > 0; j--) {
				if (source[j] < source[j - 1]) {
					temp = source[j];
					source[j] = source[j - 1];
					source[j - 1] = temp;

				}
			}
		}

		return source;
	}

	public static int[] SelectionSearch(int[] source) {
		int[] target = source;
		int length = target.length;
		int temp = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {

				if (target[i] > target[j]) {
					temp = target[i];
					target[i] = target[j];
					target[j] = temp;
				}
			}
		}
		return target;
	}
}
