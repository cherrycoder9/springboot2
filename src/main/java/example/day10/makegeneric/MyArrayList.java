package example.day10.makegeneric;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] arr; // T 타입 배열
    private int capacity; // 배열 용량
    private int size; // 현재 요소 개수

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        size = 0;
        capacity = 10; // 초기 용량
        arr = (T[]) new Object[capacity];
    }

    public void add(final T value) {
        // 현재 용량이 가득 찼으면 용량을 증가시킨다
        if (size == capacity) {
            this.capacity *= 2;
            // 변경된 용량으로 배열 복사
            this.arr = Arrays.copyOf(arr, capacity);
        }
        // 용량이 널널하면 값을 추가하고 size를 증가시킨다.
        arr[size++] = value;
    }


    public void remove(final int index) {
        // 입력한 인덱스가 0보다 작거나 들어있는 인덱스가 아닌 경우
        if (index < 0 || index >= size) {
        } else {
            // 제대로 입력한 인덱스면 한칸씩 앞으로 당겨오기
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            // 용량 검사후 감소 결정
            if (size < capacity / 2) {
                this.capacity /= 2;
                // 변경된 용량으로 배열 복사
                this.arr = Arrays.copyOf(arr, capacity);
            }
        }
    }

    public T get(final int index) {
        // 잘못입력하면 null 반환
        if (index < 0 || index >= size) {
            isNullMsg();
            return null;
        }
        // 잘 입력했으면 해당 인덱스의 값 반환
        return arr[index];
    }

    public T[] getArr() {
        return arr;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(final int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public void isNullMsg() {
        System.out.println("null 값이 들어있습니다.");
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
