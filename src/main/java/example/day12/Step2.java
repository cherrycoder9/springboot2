package example.day12;

import java.util.*;
import java.util.stream.Collectors;

public class Step2 {
    public static void main(final String[] args) {
        // 1. Map 컬렉션 객체
        final Map<String, Integer> map = new HashMap<>();

        // 2.
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 3); // value는 중복이 가능
        map.put("five", 5);
        map.put("five", 10); // key값이 중복이면 마지막 것으로 교체됨
        System.out.println("map = " + map);

        // 3.
        final int size = map.size();
        System.out.println("size = " + size);

        // 4.
        final int value = map.get("four");
        System.out.println("value = " + value);

        // 5.
        map.remove("five");
        System.out.println("map = " + map);

        // 6.
        final Set<String> keys = map.keySet();
        System.out.println("keys = " + keys);

        final Collection<Integer> values = map.values();
        System.out.println("values = " + values);

        final Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("entries = " + entries);

        // map 객체 내 엔트리 순회
        // 1.
        final Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            final String key = iterator.next();
            final int value2 = map.get(key);
            System.out.println("key = " + key + ", value = " + value2);
        }

        // 2. 향상된 for문
        for (final String key : map.keySet()) {
            final int value2 = map.get(key);
            System.out.println("key = " + key + ", value = " + value2);
        }

        for (final Integer value3 : map.values()) {
            System.out.println("value = " + value3);
        }

        // 3. forEach
        map.forEach((key, value4) -> {
            System.out.println("key = " + key + ", value = " + value4);
        });

        // 4. map 문
        map.keySet().stream().map(key -> {
            System.out.println(key);
            System.out.println(map.get(key));
            return key;
        }).collect(Collectors.toSet());

    }
}
