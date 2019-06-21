package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Shopee的零食柜
 * @Author: coffee
 */
public class ShopeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        int n = Integer.parseInt(one.split(" ")[0]);
        int m = Integer.parseInt(one.split(" ")[1]);
        String two = scanner.nextLine();
        List<Integer> data = Arrays.stream(two.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        getBestResult(data, result, 1, m);
    }

    /**
     * 最低分1段，最多分n-m+1段
     * 这里的n指取几个
     */
    private static int getBestResult(List<Integer> data, List<List<Integer>> result, int n, int m) {
        if (m == 1) {
            if (null == result.get(m-1)) {
                List<Integer> five = new ArrayList<>();
                result.add(m-1, five);
            }
            result.get(m - 1).clear();
            for (Integer i : data) {
                result.get(m - 1).add(i);
            }

            return getMaxValue(result);
        }
//        for (int i = 1; i < data.size() - m; i++) {
//            getBestResult(data, result, n + i, m);
//        }
        return 0;
    }

    static int getMaxValue(List<List<Integer>> data) {
        int max = 0;
        int tmp = 0;
        for (List<Integer> item : data) {
            tmp = item.stream().mapToInt(i -> i).sum();
            if (max < tmp) {
                max = tmp;
            }
        }
        return max;
    }
}
