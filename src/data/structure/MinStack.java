package data.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: coffee
 */
class MinStack {

    /** initialize your data structure here. */
    List<Integer> data;
    Integer min;
    int tail;
    public MinStack() {
        data = new ArrayList<>();
        tail = -1;
    }

    public void push(int x) {
        if (null == min) {
            min = x;
        } else {
            min = min > x ? x : min;
        }
        tail++;
        data.add(x);
    }

    public void pop() {
        if (tail == 0) {
            min = null;
        }
        data.remove(tail);
        tail--;
    }

    public int top() {
        return data.get(tail);
    }

    public int getMin() {

        return min;
    }

    public static void main(String[] args) {

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */