package classicalSort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort_03 {
    public static void insertionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int insertNum;
        for (int i=1; i<array.length; i++) {
            insertNum = array[i];
            //已经排好序的元素个数
            int j = i-1;
            while(j>=0 && array[j]>insertNum) {
                //从后往前循环，将大于insertNum的数向后移一格
                array[j+1] = array[j];
                j--;
            }
            //将需要插入的元素放在要插入的位置
            array[j+1] = insertNum;
        }
    }
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
