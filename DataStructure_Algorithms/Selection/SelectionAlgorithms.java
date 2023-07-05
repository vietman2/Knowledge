package Knowledge.DataStructure_Algorithms.Selection;

public class SelectionAlgorithms {
    public static int selection(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }

        int q = partition(arr, p, r);
        int k = q - p + 1;

        if (i == k) {
            return arr[q];
        } else if (i < k) {
            return selection(arr, p, q - 1, i);
        } else {
            return selection(arr, q + 1, r, i - k);
        }
    }
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, r);

        return i + 1;
    }
    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int linearSelect(int[] arr, int p, int r, int i) {
        // divide elements into n/5 groups
        // find median of each group
        // find median of medians
        // partition around median of medians
        // recursively find ith smallest element in left or right partition

        int n = r - p + 1;

        if (n <= 5) {
            return selection(arr, p, r, i);
        }

        int[] medians = new int[n / 5];

        for (int j = 0; j < n / 5; j++) {
            int left = p + j * 5;
            int right = left + 4;

            medians[j] = selection(arr, left, right, 3);
        }

        int medianOfMedians = linearSelect(medians, 0, medians.length - 1, medians.length / 2);

        // partition around median of medians
        int q = partition(arr, p, r, medianOfMedians);

        int k = q - p + 1;

        if (i == k) {
            return arr[q];
        } else if (i < k) {
            return linearSelect(arr, p, q - 1, i);
        } else {
            return linearSelect(arr, q + 1, r, i - k);
        }
    }
    private static int partition(int[] arr, int p, int r, int x) {
        // partition around x
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (arr[j] == x) {
                swap(arr, j, r);
                break;
            }
        }

        int pivot = arr[r];

        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, r);

        return i + 1;
    }

}
