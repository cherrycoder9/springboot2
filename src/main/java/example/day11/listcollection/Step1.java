package example.day11.listcollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Step1 {
    public static void main(final String[] args) {
        // 1. 리스트 컬렉션
        final List<String> list = new ArrayList<>();

        // 2. 리스트내 요소 추가
        list.add("유재석");
        list.add("강호동");
        list.add("신동엽");
        list.add(0, "서장훈");
        System.out.println(list);

        // 3. 리스트 내 특정 위치에 요소 추가
        list.set(0, "김희철");

        // 4.리스트를 출력
        System.out.println(list);

        // 5. 리스트내 요소 개수
        final int size = list.size();
        System.out.println("size = " + size);

        // 6. 리스트내 특정 위치 요소 호출
        final String str1 = list.get(1);
        System.out.println("str1 = " + str1);

        // 7. 리스트내 특정 요소의 값 검색
        final boolean bool1 = list.contains("강호동");
        System.out.println("bool1 = " + bool1);

        // 8. 리스트의 요소의 위치 검색
        final int index1 = list.indexOf("서장훈");
        System.out.println("index1 = " + index1);

        // 9. 리스트내 특정 요소 삭제 
        list.remove(1);
        System.out.println(list);

        // 10. 리스트내 요소 순회
        // 10-1. 향상된 for 문
        for (final String s : list) {
            System.out.println(s);
        }

        // 10-2. 일반 for 문
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 10-3. forEach 함수, 요소의 개수를 하나씩 반환해서 반복
        list.forEach(System.out::println);
        list.forEach(s -> System.out.println(s));

        // 10-4. 요소의 개수를 하나씩 반환해서 반복후 결과(return)해서 반환
        // 반복하면서 return 값들을 하나의 배열/컬렉션으로 반환 받을 수 있다.
        // 주로 카피/복사 할때 사용된다. 반복하면서 실행결과를 반환 받을 수 있다.
        System.out.println(list.hashCode());
        final List<String> newList = list.stream()
                .map(s -> {
                    System.out.println(s);
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("newList = " + newList);
        newList.remove(0);
        System.out.println(list);
        System.out.println(newList);

        ///////////////////////////
        final List<String> vector = new Vector<>();
        vector.add("유재석");
        System.out.println("vector = " + vector);

        ///////////////////////////
        final List<String> list1 = new ArrayList<>();
        final List<String> list2 = new LinkedList<>();

        long startTime;
        long endTime;
        long result;

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            // list1.add(String.valueOf(i));
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        result = endTime - startTime;
        System.out.println("10만개 저장하는 ArrayList 걸린시간: " + result);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            // list2.add(String.valueOf(i));
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        result = endTime - startTime;
        System.out.println("10만개 저장하는 LinkedList 걸린시간: " + result);
    } // main end
} // class end
