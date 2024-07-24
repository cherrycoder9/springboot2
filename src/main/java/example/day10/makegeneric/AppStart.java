package example.day10.makegeneric;

public class AppStart {
    public static void main(final String[] args) {
        final MyArrayList<Integer> imal = new MyArrayList<>();
        final MyArrayList<String> smal = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            imal.add(i);
        }
        imal.remove(3);
        smal.add("안녕");
        smal.add("하이");
        System.out.println(imal);
        System.out.println(smal);
        System.out.println(smal.get(1));
        smal.get(3);
    }
}
