package recursion;

import java.util.Arrays;

/**
 * @Author: zouhongxue
 * @Date: 2019/4/25 3:13 PM
 */
public class ReverseStack {
    public int[] reverseStackRecursively(int[] stack, int top) {
        reverse(stack, 0);
        return stack;
    }

    private void reverse(int[] stack, int i) {
        if (i > stack.length / 2) {
            return;
        }
        reverse(stack, i+1);
        int tmp = stack[i];
        stack[i] = stack[stack.length - 1 - i];
        stack[stack.length - 1 -i] = tmp;
    }

    public static void main(String[] args) {
        ReverseStack reverseStack = new ReverseStack();
        System.out.println(Arrays.toString(reverseStack.reverseStackRecursively(new int[]{1, 2, 3, 4, 5}, 5)));
    }
}
