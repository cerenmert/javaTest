package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.compare;

public class findTheLongestString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "testng", "selenium", "jenkins", "api");
        // Optional<String> longestItem =
        // list.stream().max(Comparator.comparingInt(String::length));
        // If the length of the compared items is equal, the first item is kept due to
        // stream max method.
        Optional<String> longestItem = list.stream().max((s1, s2) -> {
            System.out.println("s1: " + s1 + " s2: " + s2);
            return compare(s1.length(), s2.length());
        });
        System.out.println("The longest item in the list: " + longestItem.get());
    }
}
