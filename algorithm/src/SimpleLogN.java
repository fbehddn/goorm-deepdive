public class SimpleLogN {
    public static void main(String[] args) {
        int n = 50; // 탐색 대상 값
        int count = 0; // 반복 횟수를 세기 위한 변수

        for (int i = 1; i < n; i *= 2) {
            System.out.println("현재 i의 값: " + i);
            count++;
        }

        System.out.println("총 반복 횟수: " + count);
    }
}