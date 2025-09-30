package br.edu.exemplo;

public class Heap {

    public static void sort(String[] a) {
        int n = a.length;

        for (int k = n / 2 - 1; k >= 0; k--) {
            sink(a, k, n);
        }
    
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end);
            sink(a, 0, end);
        }
    }

    public static String show(String[] a) {
        if (a.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0)
                return false;
        }
        return true;
    }

    private static void sink(String[] a, int k, int n) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int largest = k;

            if (left < n && a[largest].compareTo(a[left]) < 0)
                largest = left;
            if (right < n && a[largest].compareTo(a[right]) < 0)
                largest = right;
            if (largest == k)
                break;

            swap(a, k, largest);
            k = largest;
        }
    }

    private static void swap(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
