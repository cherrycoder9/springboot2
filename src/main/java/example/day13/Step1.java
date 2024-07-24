package example.day13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Step1 {


    public static void main(final String[] args) {
        // 1. 스택
        final Stack<Integer> coinBox = new Stack<>();

        // 2. 스택에 push
        coinBox.push(1);
        coinBox.push(2);
        coinBox.push(3);
        coinBox.push(4);
        System.out.println("coinBox = " + coinBox);

        // 4. 스택
        final Integer topData = coinBox.peek();
        System.out.println("topData = " + topData);

        // 3. 스택 pop
        coinBox.pop();
        System.out.println("coinBox = " + coinBox);
        coinBox.pop();
        System.out.println("coinBox = " + coinBox);
        coinBox.pop();
        System.out.println("coinBox = " + coinBox);
        coinBox.pop();
        System.out.println("coinBox = " + coinBox);

        // 5. 큐
        final Queue<Integer> pointBox = new LinkedList<>();

        // 6. 큐 dequeue
        pointBox.offer(1);
        pointBox.offer(2);
        pointBox.offer(3);
        pointBox.offer(4);
        System.out.println("pointBox = " + pointBox);

        // 7. 큐 peak
        final Integer frontData = pointBox.peek();
        System.out.println("frontData = " + frontData);

        // 8. 큐 dequeue
        pointBox.poll();
        System.out.println("pointBox = " + pointBox);
        pointBox.poll();
        System.out.println("pointBox = " + pointBox);
        pointBox.poll();
        System.out.println("pointBox = " + pointBox);
        pointBox.poll();
        System.out.println("pointBox = " + pointBox);

    } // main end
} // class end
