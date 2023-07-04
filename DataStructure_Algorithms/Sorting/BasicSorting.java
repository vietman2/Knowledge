package Knowledge.DataStructure_Algorithms.Sorting;

public class BasicSorting {
    public static int[] SelectionSort(int[] array) {
        for (int last = array.length-1; last > 0; last--) {
            // 가장 큰 수의 위치를 찾는다
            int max = 0;
            for (int i = 1; i <= last; i++) {
                if (array[i] > array[max]) {
                    max = i;
                }
            }

            // 가장 큰 수와 마지막 수를 교환한다
            int temp = array[last];
            array[last] = array[max];
            array[max] = temp;
        }

        return array;
    }

    public static int[] InsertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            // 0부터 i까지의 배열을 정렬한다
            int j = i - 1;
            int key = array[i];

            while (0 <= j && key < array[j]) {
                // key보다 큰 수는 한 칸씩 뒤로 이동한다
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

        return array;
    }

    public static int[] BubbleSort(int[] array) {
        // 왼쪽부터 차례대로 순서대로 되어있지 않으면 자리를 바꾸고
        // 오른쪽부터 하나씩 관심대상에서 제외하며 정렬해야 할 대상을 줄인다
        for (int last = array.length-1; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i+1]) {
                    // 두 수를 교환한다
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }

        return array;
    }
    
}
