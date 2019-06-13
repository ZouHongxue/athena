package data.structure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ {leetCode 1079} 组合+排列
 * @Author: coffee
 */
public class Permutation {
    private List<String> tmpString = new ArrayList<>();
    public int numTilePossibilities(String tiles) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < tiles.length(); i++) {
            permutation(tiles.length(), i + 1, result, tiles);
        }
        result.forEach(System.out::print);
        return result.size();
    }

    /**
     * @param length 取样空间
     * @param count 需要取的数量
     * @param result 结果
     * @param tiles 单词
     */
    private void permutation(int length, int count, List<String> result, String tiles) {
        for (int i = length; i >= count; i--) {
            tmpString.add(String.valueOf(tiles.charAt(i - 1)));
            if (count > 1) {
                permutation(i - 1, count - 1, result, tiles);
            }
            if (!result.contains(tmpString.toString())) {
                result.add(tmpString.toString());
            }
            tmpString.clear();
        }
    }

    public static void main(String[] args) {
        String tiles = "123";
        Permutation permutation = new Permutation();
        System.out.println(permutation.numTilePossibilities(tiles));
    }
}
