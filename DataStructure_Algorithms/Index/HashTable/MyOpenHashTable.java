package Knowledge.DataStructure_Algorithms.Index.HashTable;

public class MyOpenHashTable {
    private Integer table[];
    int numItems;
    static final Integer DELETED = -12345, NOT_FOUND = -1;

    public MyOpenHashTable(int size) {
        table = new Integer[size];
        numItems = 0;
    }

    private int hashFunction(int i, Integer x) {
        return (x+i) % table.length;        // linear probing
    }

    public Integer search(Integer x) {
        int slot;

        for (int i = 0; i < table.length; i++) {
            slot = hashFunction(i, x);
            if (table[slot] == null) {
                return NOT_FOUND;
            } else if (table[slot] == x) {
                return slot;
            }
        }

        return NOT_FOUND;
    }

    public void insert(Integer x) {
        int slot;
        if (numItems == table.length) {
            System.out.println("Table is full");
            return;
        }
        else {
            for (int i = 0; i < table.length; i++) {
                slot = hashFunction(i, x);
                if (table[slot] == null || table[slot] == DELETED) {
                    table[slot] = x;
                    numItems++;
                    return;
                }
            }
        }
    }

    public void delete(Integer x) {
        int slot;

        for (int i = 0; i < table.length; i++) {
            slot = hashFunction(i, x);
            if (table[slot] == null) System.out.println("Not found");
            else if (table[slot] == x) {
                table[slot] = DELETED;
                numItems--;
                return;
            }
        }
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        numItems = 0;
    }
}
