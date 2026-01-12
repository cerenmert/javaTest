package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sortAfterConcatenatingTwoList_thirdMethod {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("ceren", "anıl", "elif", "cemal", "berfin", "hüso");
        List<String> list2 = Arrays.asList("öykü", "ferda", "hülya", "lara");
        list1.addAll(list2);
        Collections.sort(list1);
        System.out.println("Sorted concatenated list: " + list1);
    }
}
