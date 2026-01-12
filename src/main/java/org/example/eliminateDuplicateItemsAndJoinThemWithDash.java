package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class eliminateDuplicateItemsAndJoinThemWithDash {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("ceren", "anıl", "elif", "cemal", "berfin", "hüso");
        List<String> list2 = Arrays.asList("ceren", "anıl", "öykü", "ferda", "hülya", "lara");
        String item = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.joining("-"));
        System.out.println(item);
    }
}
