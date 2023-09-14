import java.util.*;

public class Stacks {

    public static void printStack (Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan (int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1 ; i < stocks.length ; i++) {
            while (!s.isEmpty() && stocks[i] > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {100,80,60,70,60,82,100};
        int[] span = new int [stocks.length];
        stockSpan (stocks, span);
        for (int i : span) {
            System.out.print(i + " ");
        }
    }

}
