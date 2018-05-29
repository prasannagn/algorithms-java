package string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collector;

//Reverse words in a given string
public class ReverseWords {
    public static void main(String[] args) {
        String str = " geeks quiz practice code. geeks quiz practice code!";
        reverseWords(str);
    }

    private static void reverseWords(String str) {
        String[] words = str.split("\\s+");
        Deque<String> stringDeque =
        Arrays.stream(words).collect(
                Collector.of(
                        ArrayDeque::new,
                        ArrayDeque::addFirst,
                        (acc,acc2)->{
                            acc.addAll(acc2);
                            return acc;
                        }
                )
        );

        while (stringDeque.peekFirst() != null){
            System.out.print(stringDeque.removeFirst() + " ");
        }
    }
}
