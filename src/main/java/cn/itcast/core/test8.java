package cn.itcast.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.LongStream;

@Data
@AllArgsConstructor
@NoArgsConstructor

class uUser {
    private Integer id;
    private String userName;
    private int age;


}

public class test8 {
    public static void main(String[] args) {
        uUser u1 = new uUser(11, "a", 23);
        uUser u2 = new uUser(12, "b", 24);
        uUser u3 = new uUser(13, "c", 22);
        uUser u4 = new uUser(14, "d", 28);
        uUser u5 = new uUser(16, "e", 26);
        List<uUser> list = Arrays.asList(u1, u2, u3, u4, u5);
        list.stream().filter(uUser -> uUser.getId() % 2 == 0).
                filter(uUser -> uUser.getAge()>23).map(uUser -> uUser.getUserName().toUpperCase())
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                }).limit(1).forEach(System.out::println);
        long reduce = LongStream.rangeClosed(0L, 2).parallel().reduce(1, Long::sum);
        System.out.println(reduce);
    }

}
