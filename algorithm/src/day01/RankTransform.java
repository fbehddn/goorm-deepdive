package day01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RankTransform {
    public static void main(String[] args) {
        int[] input = {40, 10, 20, 30};
        int[] result = arrayRankTransform(input);

        System.out.println(Arrays.toString(result));
    }

    public static int[] arrayRankTransform(int[] input) {
        if (input.length == 0) return new int[0];

        List<Integer> lists = new LinkedList<>(); // 40 10 20 30
        for (int i : input) {
            lists.add(i);
        }

        int[] result = new int[input.length];
        List<Integer> copiedList = new LinkedList<>(lists);
        copiedList.sort(null); // 10 20 30 40

        int rank = 1;

        for (int i = 0; i < copiedList.size(); i++) {
            int currentValue = copiedList.get(i);

            if (i > 1 && copiedList.get(i).equals(copiedList.get(i - 1))) {
                rank--;
            }
            for (int j = 0; j < lists.size(); j++) {
                if (lists.get(j).equals(currentValue)) {
                    result[j] = rank;
                }
            }
            rank++;
        }
        return result;
    }
}


