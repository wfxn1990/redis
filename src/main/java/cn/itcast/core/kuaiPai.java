package cn.itcast.core;

public class kuaiPai {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76,  13, 27, 49};
        paiXu(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void paiXu(int[] arr ,int left,int right) {
        if (left > right) {
            return;
        }
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] >= base && i<j) {
                j--;
            }
            while (arr[i] <= base && i<j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        paiXu(arr, left, i - 1);
        paiXu(arr,j+1,right);
    }

}
