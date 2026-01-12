package org.example;

import java.util.HashMap;
import java.util.Map;

public class hashmapExample {
    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple";
        String[] words = text.split(" ");

        // Create a HashMap to store word counts
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1 );
            //We can use above code block or below code block to count the words

           /* if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }*/
        }

        for (String word : wordCount.keySet()) {
            System.out.println(word + " : " + wordCount.get(word));
        }

        //We can use above code block or below code block to print the word count

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
