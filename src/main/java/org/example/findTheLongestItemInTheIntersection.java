package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class findTheLongestItemInTheIntersection {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("ceren", "anıl", "elif", "cemal", "berfin", "hüso");
        List<String> list2 = Arrays.asList("ceren", "anıl", "öykü", "ferda", "hülya", "lara");
        Optional<String> longestItemInTheIntersection = list1.stream()
                        .filter(list2::contains)
                        .collect(Collectors.toList())
                        .stream()
                        .max((s1, s2) -> s1.length() - s2.length());
        System.out.println(longestItemInTheIntersection);
    }
}
