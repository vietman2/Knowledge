package Knowledge.DataStructure_Algorithms.Heap;

public class MyHeap<E extends Comparable<E>> implements HeapInterface<E> {
    private E heap[];
    private int numItems;

    public MyHeap(int capacity) {
        // 생성자 1
        heap = (E[]) new Comparable[capacity];
        numItems = 0;
    }

    public MyHeap(E B[], int numElements) {
        // 생성자 2
        heap = B;
        numItems = numElements;
    }

    public void insert(E item) {
        // 새로운 노드를 힙에 추가
        if (numItems == heap.length) {
            // 힙이 꽉 찬 경우 에러처리
            throw new RuntimeException("Heap is full");
        }
        // 그렇지 않다면 힙의 마지막 노드에 새로운 노드를 추가
        heap[numItems] = item;          // 새로운 노드를 힙의 마지막 노드에 추가
        percolateUp(numItems);          // 힙 속성을 만족시키기 위해 힙을 재구성
        numItems++;
    }

    public E deleteMax() {
        if (isEmpty()) {
            // 힙이 비어있는 경우 에러처리
            throw new RuntimeException("Heap is empty");
        }
        // 그렇지 않다면 힙의 최대값을 리턴하고 삭제
        E maxItem = heap[0];            // 최대값 임시 저장
        heap[0] = heap[numItems - 1];   // 힙의 마지막 노드를 루트로 이동
        numItems--;
        percolateDown(0);               // 힙 속성을 만족시키기 위해 힙을 재구성
        return maxItem;
    }

    public E max() {
        if (isEmpty()) {
            // 힙이 비어있는 경우 에러처리
            throw new RuntimeException("Heap is empty");
        }
        // 그렇지 않다면 힙의 최대값을 리턴
        return heap[0];
    }

    public void buildHeap() {
        if (numItems >= 2) {
            // 힙의 크기가 2 이상인 경우에만 힙을 재구성
            for (int i = (numItems - 2) / 2; i >= 0; i--) {
                percolateDown(i);
            }
        }
    }

    public boolean isEmpty() {
        // 힙이 비어있는지 확인
        return numItems == 0;
    }

    public void clear() {
        // 힙의 모든 노드를 삭제
        heap = (E[]) new Comparable[heap.length];
        numItems = 0;
    }

    private void percolateUp(int i) {
        // 힙 속성을 만족시키기 위해 힙을 재구성
        int parent = (i - 1) / 2;
        if (parent >= 0 && heap[i].compareTo(heap[parent]) > 0) {
            E temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            percolateUp(parent);
        }
    }

    private void percolateDown(int i) {
        int child = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (child <= numItems - 1) {
            if (rightChild <= numItems - 1 && heap[rightChild].compareTo(heap[child]) > 0) {
                child = rightChild;
            }
            if (heap[i].compareTo(heap[child]) < 0) {
                E temp = heap[i];
                heap[i] = heap[child];
                heap[child] = temp;
                percolateDown(child);
            }
        }
    }
}
