package chap10.RadixSort;

import java.util.LinkedList;

public class RadixSort {


	// Define the queues.
	private static LinkedList[] q = { new LinkedList<Integer>(), // 0
			new LinkedList<Integer>(), // 1
			new LinkedList<Integer>(), // 2
			new LinkedList<Integer>(), // 3
			new LinkedList<Integer>(), // 4
			new LinkedList<Integer>(), // 5
			new LinkedList<Integer>(), // 6
			new LinkedList<Integer>(), // 7
			new LinkedList<Integer>(), // 8
			new LinkedList<Integer>() // 9
	};
	


	/**
	 * Sorts an array of objects (integers) using radix sort.
	 * 
	 * @param list
	 *            The unsorted list.
	 * @return The sorted list.
	 */
	public  Object[] sort(Object[] list) {
		// 최대 몇자리 수인지 계산
		int maxDigits = getMaxDigits(list);

		// 몇자리 수인지 에서 반복
		for (int r = 1; r <= maxDigits; r++) {

			// Iterate through every number.
			int radix;
			for (int n = 0; n < list.length; n++) {

				radix = getDigitAt(Integer.parseInt(list[n].toString()), r);
				// 1의 자리부터 카운팅 솔트 방식으로 순서대로 linked list 에 적재
				q[radix].offer(list[n]);
			}

			// 그후 순서대로 꺼내서 리스트에 재배열 반복.
			int a = 0;
			for (int k = 0; k < q.length; k++) {
				// Go through every element in the queue.
				while (q[k].peek() != null) {
					list[a++] = q[k].poll();
				}
			}

		}

		// Return the list, it is now sorted.
		return list;

	}

	/**
	 * Gets the maximum digits of a list of integers.
	 * 
	 * @param list
	 * @return
	 */
	public  int getMaxDigits(Object list[]) {
		// Define the max digits.
		int maxDigits = 0;

		// Iterate through the list.
		int digits;
		for (int i = 0; i < list.length; i++) {

			// Cast the number to a string.
			digits = getDigits(Integer.parseInt(list[i].toString()));

			// Compare the lengths.
			if (digits > maxDigits) {
				maxDigits = digits;
			}

		}

		// Return the max digits.
		return maxDigits;
	}

	/**
	 * Gets the number of digits the specified number has.
	 * 
	 * @param i
	 * @return
	 */
	public  int getDigits(int i) {
		if (i < 10) {
			return 1;
		}
		return 1 + getDigits(i / 10);
	}

	/**
	 * Gets the digit at the specified radix of the specified number.
	 * 
	 * @param number
	 * @param radix
	 * @return
	 */
	public  int getDigitAt(int number, int radix) {
		return (int) (number / Math.pow(10, radix - 1)) % 10;
	}

}