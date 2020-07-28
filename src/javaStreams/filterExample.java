package javaStreams;

import java.util.Arrays;
import java.util.List;

public class filterExample {

    public static void main(String[] args) {
        mapEx2_findFirst();
    }

    private static void mapEx2_findFirst() { // map will return new list
        List<Integer> list11 = Arrays.asList(3, 6, 9, 12, 15);
        Integer first = list11.stream().filter(lst -> lst % 14 == 0).findFirst().orElse(0);

        System.out.println(first);
    }
}
