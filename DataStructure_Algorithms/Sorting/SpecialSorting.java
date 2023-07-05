package Knowledge.DataStructure_Algorithms.Sorting;

public class SpecialSorting {
    public static int[] countingSort(int[] arr) {
        int[] count = new int[100];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }

        return result;
    }

    public static int[] radixSort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i] % 10]] = arr[i];
        }

        return result;
    }

    public static int[] bucketSort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[100];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }

        return result;
    }
    
}
