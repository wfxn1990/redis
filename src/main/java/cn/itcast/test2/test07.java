package cn.itcast.test2;
/*
* 统计手机号各个字符出现的次数按升序排序*/
public class test07 {
    public static void main(String[] args) {
        int[] count = new int[10];
        String mobile = "13724539987";
        for (int i = 0; i < mobile.length(); i++) {
            char c = mobile.charAt(i);
            count[c - '0']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println(i+"出现了"+count[i]);
            }
        }

    }
}
