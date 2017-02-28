package classes;

public class IntList implements Comparable {

    protected int[] data;
    protected int size;

    private static final int DEFAULT_CAPACITY = 8;

    public IntList() { this(DEFAULT_CAPACITY); }

    public IntList(int initialCapacity) {
        data = new int[initialCapacity];
    }

    public IntList(IntList original) {
        this.data = (int[]) original.data.clone();
        this.size = original.size;
    }

    public int size() { return size; }

    public int get(int index) {
        if ( index < 0 || index >= size)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        return data[index];
    }

    public void add(int value) {
        if ( size() == data.length ) setCapactity(size * 2);
        data[size++] = value;
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        data[index] = value;
    }

    public void trim() { setCapactity(size); }

    public void clear() { size = 0; }

    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    public String toString() {
        StringBuffer b = new StringBuffer(size*7);
        b.append('[');
        for (int i = 0; i < size; i ++ ){
            if (i > 0) {
                b.append(", ");
                if (i%8 == 0) b.append('\n');
            }
            b.append(data[i]);
        }
        b.append(']');
        return b.toString();
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof IntList)) return false;
        IntList that = (IntList) o;
        if (this.size() != that.size) return false;
        for (int i = 0; i < this.size; i ++)
            if (this.data[i] != that.data[i]) return false;
        return true;
    }

    public int hashCode() {
        int code = 1;
        for (int i = 0; i < size(); i ++)
            code = code * 997 + data[i];
        return code;
    }

    public int compareTo(Object o) {
        IntList that = (IntList) o;
        int n = Math.min(this.size, that.size);
        for (int i = 0; i < n; i ++) {
            if (this.data[i] < that.data[i]) return -1;
            if (this.data[i] > that.data[i]) return 1;
        }
        return this.size - that.size;
    }

    protected void setCapactity(int n) {
        assert (n >= size) : (n + "<" + size);
        if (n == data.length) return;
        int[] newdata = new int[n];
        System.arraycopy(data, 0, newdata, 0, size);
        data = newdata;
    }



}
