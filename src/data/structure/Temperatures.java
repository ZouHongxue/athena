package data.structure;

import java.util.Stack;

/**
 * @Author: coffee
 */
public class Temperatures {

    public static void main(String[] args) {
        Temperatures temperatures = new Temperatures();
        int[] test = new int[]{89,62,70,58,47,47,46,76,100,70};
        System.out.println(temperatures.dailyTemperatures(test));
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> max = new Stack<>();
        int[] res = new int[T.length];
        for(int i = T.length - 1; i >= 0; i--) {
            if(max.empty()) {
                res[i] = 0;
            } else {
                while (!max.empty() && T[i] >= T[max.peek()]) {
                    max.pop();
                }
                if (max.empty()) {
                    res[i] = 0;
                } else {
                    res[i] = max.peek() - i;
                }
            }
            max.push(i);
        }
        return res;
    }
}
