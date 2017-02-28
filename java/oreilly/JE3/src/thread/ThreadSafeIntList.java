package thread;

public class ThreadSafeIntList {

    protected int[] data;
    protected int size;

    private static final int DEFAULT_CAPACITY = 8;

    public ThreadSafeIntList() {
        data = new int[DEFAULT_CAPACITY];
    }

    public ThreadSafeIntList(ThreadSafeIntList original) {
        synchronized (original) {
            this.data = (int[]) original.data.clone();
            this.size = original.size;
        }
    }

    public synchronized int size() { return size; }

    public synchronized int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        return data[index];
    }

    public synchronized void add(int value) {
        if (size == data.length) setCapacity(size * 2);
        data[size ++] = value;
    }

    public synchronized void clear() { size = 0; }

    public synchronized  int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    protected void setCapacity(int n) {
        if (n == data.length) return;
        int[] newdata = new int[n];
        System.arraycopy(data, 0, newdata, 0, size);
        data = newdata;
    }

}
