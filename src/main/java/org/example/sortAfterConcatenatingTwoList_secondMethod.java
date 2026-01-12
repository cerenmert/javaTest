package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sortAfterConcatenatingTwoList_secondMethod {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("ceren", "anıl", "elif", "cemal", "berfin", "hüso");
        List<String> list2 = Arrays.asList("öykü", "ferda", "hülya", "lara");
        List<String> concatenatedList = new ArrayList<>();
        concatenatedList.addAll(list1);
        concatenatedList.addAll(list2);
        concatenatedList.sort(String::compareTo);
        System.out.println("Sorted concatenated list: " + concatenatedList);
    }
}
