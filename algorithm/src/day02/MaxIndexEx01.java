package day02;

import java.util.Arrays;

public class MaxIndexEx01 {
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
        int max = 0;
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        int count = 0;
        for (int a : arr) {
            if (a == max) {
                count++;
            }
        }
        int[] answer = new int[count];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == max){
                answer[index++] = i;
            }
        }
        return answer;
    }
}
