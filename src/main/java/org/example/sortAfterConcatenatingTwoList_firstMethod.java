package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class sortAfterConcatenatingTwoList_firstMethod
{
    public static void main(String[] args)
    {
        List<String> list1 = Arrays.asList("ceren", "anıl", "elif", "cemal", "berfin");
        List<String> list2 = Arrays.asList("ceren", "öykü", "ferda", "hülya", "lara");
        List<String> concatenatedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(concatenatedList); // sıralı ve tekrar eden elemanlar var
        Set<String> hashSet = new HashSet<>(concatenatedList); // benzersiz ama sırasız
        System.out.println(hashSet);
        Set<String> treeSet = new TreeSet<>(concatenatedList); // benzersiz ve sıralı
        System.out.println(treeSet);

    }
}
