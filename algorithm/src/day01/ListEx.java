package day01;

import java.util.ArrayList;

public class ListEx {
    private static final int NUM_OF_ELEMENTS = 100000;
    public static void main(String[] args) {
        System.out.println("ArrayList와 LinkedList 성능 비교 (" + NUM_OF_ELEMENTS + "개의 요소)");

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> linkedList = new ArrayList<>();

        // 추가
        System.out.println("요소 추가 중 ...");
        long startTime = System.currentTimeMillis();
        for(int i=0; i<NUM_OF_ELEMENTS; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList 추가 시간: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for(int i=0; i<NUM_OF_ELEMENTS; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList 추가 시간: " + (endTime - startTime) + "ms");


        //검색
        startTime=System.currentTimeMillis();
        for(int i=0; i<NUM_OF_ELEMENTS; i++) {
            arrayList.get(i);
        }
        endTime=System.currentTimeMillis();
        System.out.println("ArrayList 검색 시간 " + (endTime - startTime) + "ms");

        startTime=System.currentTimeMillis();
        for(int i=0; i<NUM_OF_ELEMENTS; i++) {
            linkedList.get(i);
        }
        endTime=System.currentTimeMillis();
        System.out.println("LinkedList 검색 시간 " + (endTime - startTime) + "ms");

        //삭제
        startTime=System.currentTimeMillis();
        for(int i=NUM_OF_ELEMENTS-1; i>=0; i--) {
            arrayList.remove(i);
        }
        endTime=System.currentTimeMillis();
        System.out.println("ArrayList 삭제 시간 " + (endTime - startTime) + "ms");

        startTime=System.currentTimeMillis();
        for(int i=NUM_OF_ELEMENTS-1; i>=0; i--) {
            linkedList.remove(i);
        }
        endTime=System.currentTimeMillis();
        System.out.println("LinkedList 삭제 시간 " + (endTime - startTime) + "ms");
    }
}
