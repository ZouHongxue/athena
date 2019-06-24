package data.structure.queue;

/**
 * @Author: coffee
 */
class MyCircularQueue {
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    int[] data;
    int head = -1, tail = -1;

    public MyCircularQueue(int k) {
        data = new int[k];
        String[] st = new String[1];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;

        }
        if (isEmpty()) {
            head = 0;
        }
        data[(tail + 1) % (data.length - 1)] = value;
        tail = (tail + 1) % (data.length - 1);
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        data[head] = 0;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % (data.length - 1);
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (!isEmpty()) {
            return data[head];
        }
        return -1;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (!isEmpty()) {
            return data[tail];
        }
        return -1;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if (data.length < 1) {
            return true;
        }
        return head == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if (data.length - 1 < 1) {
            return true;
        }
        return (tail + 1) % data.length == head;
    }

    public static void main(String[] args) {
        /**
         * Your MyCircularQueue object will be instantiated and called as such:*/
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.enQueue(2);
        boolean param_3 = obj.enQueue(3);
        boolean param_10 = obj.enQueue(4);
        boolean param_4 = obj.deQueue();
        int param_9 = obj.Front();
        int param_8 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();

    }
}

