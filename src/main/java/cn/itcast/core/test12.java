package cn.itcast.core;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class test12 {
    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        integers.add(6);
        integers.forEach(System.out::println);
        HashMap integerHashMap = new HashMap<>(200);
        // integerHashMap.put()
    }
}
