package example.day13;

import java.util.TreeMap;
import java.util.TreeSet;

public class Step2 {
    public static void main(final String[] args) {
        // 1. 이진 트리
        // Set 인터페이스에는 Tree 자료구조의 메소드가 없다. -> TreeSet
        final TreeSet<Integer> scores = new TreeSet<>();

        // 2.
        scores.add(23);
        scores.add(10);
        scores.add(48);
        scores.add(15);
        scores.add(7);
        scores.add(22);
        scores.add(56);

        // 3. 출력 (자동으로 정렬이 된것을 볼 수 있음)
        System.out.println("scores = " + scores);

        // 4. 순회
        scores.forEach(score -> {
            System.out.println("score = " + score);
        });

        // 5. 트리 관련 메소드 제공
        System.out.println("가장 낮은 점수, 가장 왼쪽 데이터 = " + scores.first());
        System.out.println("가장 높은 점수, 가장 오른쪽 데이터 = " + scores.last());
        System.out.println("48보다 낮은 점수 = " + scores.lower(48));
        System.out.println("48보다 큰 점수 = " + scores.higher(48));
        System.out.println("48 이거나 보다 낮은 점수 = " + scores.floor(48));
        System.out.println("48 이거나 보다 큰 점수 = " + scores.ceiling(48));
        System.out.println("내림차순 정렬 (기본은 오름차순) = " + scores.descendingSet());
        System.out.println("48 이상 = " + scores.tailSet(48, true));
        System.out.println("48 미만 = " + scores.headSet(48, false));
        System.out.println("20이상 이면서 40미만 = " + scores.subSet(20, true, 40, false));


        // 6. TreeMap
        final TreeMap<Integer, String> treeMap = new TreeMap<>();

        // 7. 
        treeMap.put(23, "apple");
        treeMap.put(10, "banana");
        treeMap.put(48, "grape");
        treeMap.put(15, "kiwi");
        treeMap.put(7, "orange");
        treeMap.put(22, "pear");
        treeMap.put(56, "melon");

        System.out.println("treeMap = " + treeMap);

        // 8.
        treeMap.entrySet().forEach(entry -> {
            System.out.println("entry = " + entry);
        });

        // 9.
        System.out.println("treeMap.firstEntry() = " + treeMap.firstEntry());
        System.out.println("treeMap.lastEntry() = " + treeMap.lastEntry());
        System.out.println("treeMap.lowerKey(48) = " + treeMap.lowerKey(48));
        System.out.println("treeMap.higherKey(48) = " + treeMap.higherKey(48));
        System.out.println("treeMap.floorEntry(48) = " + treeMap.floorEntry(48));
        System.out.println("treeMap.ceilingEntry(48) = " + treeMap.ceilingEntry(48));
        System.out.println("treeMap.descendingMap() = " + treeMap.descendingMap());
        System.out.println("treeMap.tailMap(20, true) = " + treeMap.tailMap(20, true));
        System.out.println("treeMap.headMap(48, false) = " + treeMap.headMap(48, false));
        System.out.println("treeMap.subMap(20, true, 40, false) = " + treeMap.subMap(20, true, 40, false));
        

    }
}
