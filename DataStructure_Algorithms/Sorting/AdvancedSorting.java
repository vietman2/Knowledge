package Knowledge.DataStructure_Algorithms.Sorting;

public class AdvancedSorting {
    public static int[] mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;                // 중간 위치를 계산한다

            mergeSort(array, p, q);             // 왼쪽 부분 배열 정렬
            mergeSort(array, q+1, r);           // 오른쪽 부분 배열 정렬
            merge(array, p, q, r);              // 정렬된 두 부분 배열을 합병한다
        }

        return array;
    }
    private static void merge(int[] array, int p, int q, int r) {
        // A[p...q]와 A[q+1...r]은 이미 정렬되어 있다
        // 두 배열을 합하여 A[p...r]에 저장한다
        int i = p;
        int j = q+1;
        int t = 0;

        int[] temp = new int[array.length];

        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }

        while (i <= q) {                        // 왼쪽 배열에 남아있는 수들을 복사한다
            temp[t++] = array[i++];
        }

        while (j <= r) {                        // 오른쪽 배열에 남아있는 수들을 복사한다
            temp[t++] = array[j++];
        }

        t = 0;
        i = p;

        while (i <= r) {                        // temp에 저장된 수들을 array로 다시 복사한다
            array[i++] = temp[t++];
        }
    }

    public static int[] QuickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);     // 분할

            QuickSort(array, p, q-1);           // 왼쪽 부분 배열 정렬
            QuickSort(array, q+1, r);           // 오른쪽 부분 배열 정렬
        }

        return array;
    }
    private static int partition(int[] array, int p, int r) {
        int x = array[r];                           // 피벗을 배열의 마지막 원소로 한다
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                // array[j]와 array[i]를 교환한다
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // array[i+1]와 array[r]를 교환한다
        int temp = array[i+1];
        array[i+1] = array[r];
        array[r] = temp;

        return i+1;
    }

    public static int[] HeapSort(int[] array) {
        buildMaxHeap(array);                        // 최대 힙을 만든다

        for (int i = array.length-1; i > 0; i--) {
            array[i] = deleteMax(array);
        }

        return array;
    }
    private static void buildMaxHeap(int[] array) {
        int numItems = array.length;

        if (numItems >= 2) {
            for (int i = (numItems-2)/2; i >= 0; i--) {
                percolateDown(array, i, numItems);
            }
        }
    }
    private static void percolateDown(int[] array, int i, int numItems) {
        int child = 2 * i + 1;                      // 왼쪽 자식의 인덱스
        int rightChild = 2 * i + 2;                 // 오른쪽 자식의 인덱스

        if (rightChild < numItems && array[rightChild] > array[child]) {
            // 오른쪽 자식이 더 크면 오른쪽 자식과 교환한다
            child = rightChild;
        }
        if (array[i] < array[child]) {
            // 자식의 키 값이 더 크면 자식과 교환한다
            int temp = array[i];
            array[i] = array[child];
            array[child] = temp;

            percolateDown(array, child, numItems);
        }
    }
    private static int deleteMax(int[] array) {
        int max = array[0];                         // 최대 힙의 루트에 있는 값을 삭제한다
        array[0] = array[array.length-1];

        percolateDown(array, 0, array.length-1);    // 힙을 재구성한다

        return max;
    }

}
