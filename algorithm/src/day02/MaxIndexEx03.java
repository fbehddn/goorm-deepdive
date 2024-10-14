package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxIndexEx03 {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 3, 2, 5, 6, 6, 1};
        int[] arr2 = {9, 2, 3, 1, 0, 2, 9, 9};
        int[] arr3 = {0, 2, 4, 2, 4, 0};

        System.out.println("[입력1]: " + Arrays.toString(arr1));
        System.out.println("[출력1]: " + Arrays.toString(solution(arr1)));

        System.out.println("[입력2]: " + Arrays.toString(arr2));
        System.out.println("[출력2]: " + Arrays.toString(solution(arr2)));

        System.out.println("[입력3]: " + Arrays.toString(arr3));
        System.out.println("[출력3]: " + Arrays.toString(solution(arr3)));

    }

    public static int[] solution(int[] arr) {

        //최대값 구하기
        int max = Arrays.stream(arr).max().getAsInt();

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++) {
            if(arr[i] == max) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
