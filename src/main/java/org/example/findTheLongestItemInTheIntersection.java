package org.example;

import java.util.*;

public class findTheLongestItemInTheIntersection {

    static List<String> list1 = Arrays.asList("ceren", "anıl", "elif", "cemal", "berfin");
    static List<String> list2 = Arrays.asList("ceren", "anıl", "şeker", "alin", "lina");

    public static void main(String[] args) {
        findLongestInIntersection1();
        findLongestInIntersection2();
    }

    public static void findLongestInIntersection1() {
        Optional<String> longestItemInTheIntersection = list1.stream()
                .filter(list2::contains)
                .max(Comparator.comparingInt(String::length));
        longestItemInTheIntersection.ifPresent(name -> System.out.println("en uzun ortak isim: " + name));
        longestItemInTheIntersection.ifPresent(System.out::println);
        System.out.println(longestItemInTheIntersection); // Output: Optional[ceren]
        // Optional kullandık ve NullPointerException engelledik
        // Eğer kesişim kümesinde eleman yoksa Optional.empty döner, null pointer hatası vermez
    }


    public static void findLongestInIntersection2() {
        // list2'yi bir Set'e dönüştürüyoruz (Arama işlemi çok daha hızlı olur)
        Set<String> set2 = new HashSet<>(list2);
        // Stream işlemini tek seferde bitiriyoruz
        String result = list1.stream()
                .filter(set2::contains) // Set üzerinde "contains" işlemi ışık hızındadır
                .max(Comparator.comparingInt(String::length))
                .orElse("Ortak eleman yok");

        System.out.println("findLongestInIntersection2:  " + result);

        // findLongestInIntersection1'de list2::contains kısmı, list2 bir ArrayList olduğu için arka planda
        // her bir isim için tüm listeyi tek tek kontrol eder (O(n) karmaşıklığı).
        // Eğer listeler çok uzun olsaydı, bu işlem bilgisayarı yormaya başlardı.
        // Set (Küme) yapısı ise elemanları bir "hash" tablosunda tuttuğu için bir elemanın kümede olup olmadığını
        // anında (O(1) karmaşıklığı) söyler.
        // List Kullanmak: Aradığın kitabın rafta olup olmadığını anlamak için birinci kitaptan başlayıp
        // sonuncu kitaba kadar tek tek bakmaktır.
        // Set Kullanmak: Kütüphanenin bilgisayar sistemine bakıp kitabın yerini (veya olup olmadığını)
        // anında görmektir.
    }
}
