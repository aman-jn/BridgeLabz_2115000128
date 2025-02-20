import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % buffer.length;
        if (size < buffer.length) {
            size++;
        } else {
            head = (head + 1) % buffer.length;
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(head + i) % buffer.length]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(3);
        circularBuffer.insert(1);
        circularBuffer.insert(2);
        circularBuffer.insert(3);
        System.out.println("Buffer after inserting 1, 2, 3: " + circularBuffer.getBuffer());

        circularBuffer.insert(4);
        System.out.println("Buffer after inserting 4 (overwriting oldest): " + circularBuffer.getBuffer());
    }
}
