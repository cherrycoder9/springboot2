package example.day12;

import example.day09.lombok.Member;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class Step1 {
    public static void main(final String[] args) {
        // 1. HashSet
        final Set<String> set = new HashSet<>();

        // 2. 리스트와 달리 중복을 허용하지 않는다.
        set.add("Hello");
        set.add("World");
        set.add("Java");
        set.add("Programming");
        set.add("Language");
        set.add("Language");

        // 3.
        System.out.println("set = " + set);

        // 4.
        System.out.println("size = " + set.size());

        // 5.
        set.remove("Hello");
        System.out.println("set = " + set);

        // 6.
        final boolean bool = set.contains("Language");
        System.out.println("bool = " + bool);

        // 7. set 컬렉션 순회 방법
        // set 인덱스는 없으므로 .get() 사용 불가
        final Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("it.next() = " + it.next());
        }

        for (final String s1 : set) {
            System.out.println("s1 = " + s1);
        }

        set.forEach(s2 -> System.out.println("s2 = " + s2));

        final Set<String> newSet = set.stream().map(s3 -> {return s3;}).collect(Collectors.toSet());
        System.out.println("newSet = " + newSet);

        // 중복제거 한다고 했는데, 만약에 필드가 2개 이상인 객체이면???
        final Set<Member> memberSet = new HashSet<>();
        //
        memberSet.add(new Member(1001, "서태준"));
        memberSet.add(new Member(1002, "정해성"));
        memberSet.add(new Member(1003, "이길상"));
        System.out.println("memberSet = " + memberSet);
        // 필드가 2개 이상일땐 중복된 값이 들어간다
        memberSet.add(new Member(1003, "이길상"));
        System.out.println("memberSet = " + memberSet);
    }
}
