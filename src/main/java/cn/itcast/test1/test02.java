package cn.itcast.test1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test02 {
    public static void main(String[] args) {
        String ss = "abaabbacccc";
        isNotRepeat(ss);
    }

    public static void isNotRepeat(String s) {
        char[] ch = s.toCharArray();
        Set set = new HashSet<>();
        for (char c : ch) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                break;
            }

        }
        Iterator iterator = set.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
