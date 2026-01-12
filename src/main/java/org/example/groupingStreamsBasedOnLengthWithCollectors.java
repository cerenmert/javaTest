package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupingStreamsBasedOnLengthWithCollectors {
    public static void main( String  [] args ) {
        List<String> names = List.of("ceren","anıl","elif","cemal","berfin","hüsmen");
        Map<Integer,List<String>> groupedNames = names
                .stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedNames);
    }
}
