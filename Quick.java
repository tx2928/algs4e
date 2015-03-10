public class Quick
{
	private Quick() { }
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int low, int high) {
		if (high <= low) return;
		int j = partition(a, low, high);
		sort(a, low, j-1);
		sort(a, j+1, high);
	}

	private static int partition(Comparable[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		Comparable v = a[low];
		while (true) {
			while (less(a[++i], v)) 
				if (i == high) break;
			while (less(v, a[--j])) 
				if (j == low) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, low, j);
		return j;
	}

	public static Comparable select(Comparable[] a, int k) {
		if (k < 0 || k >= a.length) {
			throw new IndexOutOfBoundsException("Selected element out of bounds");
		}
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;
		while (hi > lo) {
			int i = partition(a, lo, hi);
			if      (i > k) hi = i - 1;
			else if (i < k) lo = i + 1;
			else return a[i];
		}
		return a[lo];
	}

	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Quick.sort(a);
        show(a);
		
		StdRandom.shuffle(a);
		
		StdOut.println();
		for (int i = 0; i < a.length; i++) {
			String ith = (String) Quick.select(a, i);
			StdOut.println(ith);
		}		
	}
}

