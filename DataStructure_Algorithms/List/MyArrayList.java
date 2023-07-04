package Knowledge.DataStructure_Algorithms.List;

public class MyArrayList<T> implements ListInterface<T> {
    private T[] items;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 100;

    public MyArrayList() {
        // 생성자
        items = (T[]) new Object[DEFAULT_CAPACITY];
        numItems = 0;
    }
    public MyArrayList(int n) {
        // 생성자 (n은 최대 크기)
        items = (T[]) new Object[n];
        numItems = 0;
    }

    public void add(int index, T x) {
        // index 위치에 x를 삽입
        if (index < 0) {
            // 잘못된 입력
            throw new IndexOutOfBoundsException();
        }
        if (numItems >= items.length) {
            // 배열 용량 초과
            throw new IndexOutOfBoundsException();
        }
        for (int i = numItems - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = x;
        numItems++;
    }

    public void append(T x) {
        // 리스트의 끝에 x를 삽입
        if (numItems >= items.length) {
            // 배열 용량 초과
            throw new IndexOutOfBoundsException();
        }
        items[numItems++] = x;
    }

    public T remove(int index) {
        // index 위치의 항목을 삭제
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        }
        else {
            T tmp = items[index];
            for (int i = index; i < numItems - 1; i++) {
                items[i] = items[i + 1];
            }
            numItems--;
            return tmp;
        }
    }

    public boolean removeItem(T item) {
        // 주어진 item을 삭제
        int index = 0;

        while (index < numItems && items[index] != item) {
            index++;
        }
        if (index == numItems) return false;
        else {
            for (int i = index; i < numItems - 1; i++) {
                items[i] = items[i + 1];
            }
            numItems--;
            return true;
        }
    }

    public T get(int index) {
        // index 위치의 항목을 반환
        if (index < 0 || index > numItems - 1) {
            return null;
        }
        else {
            return items[index];
        }
    }

    public void set(int index, T x) {
        // index 위치의 항목을 x로 대체
        if (index < 0 || index > numItems - 1) {
            throw new IndexOutOfBoundsException();
        }
        else {
            items[index] = x;
        }
    }

    public int indexOf(T x) {
        // x를 탐색하여 인덱스를 반환
        for (int i = 0; i < numItems; i++) {
            if (items[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        // 리스트의 크기를 반환
        return numItems;
    }

    public boolean isEmpty() {
        // 리스트가 비어있는지 확인
        return numItems == 0;
    }

    public void clear() {
        // 리스트의 모든 항목 삭제
        numItems = 0;
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }
}
