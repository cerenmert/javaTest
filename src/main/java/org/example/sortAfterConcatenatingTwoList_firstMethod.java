package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class sortAfterConcatenatingTwoList_firstMethod
{
    public static void main(String[] args)
    {
        List<String> list1 = Arrays.asList("ceren", "anıl", "elif", "cemal", "berfin", "hüso");
        List<String> list2 = Arrays.asList("öykü", "ferda", "hülya", "lara");
        List<String> concatenatedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted concatenated list: " + concatenatedList);
    }
}
