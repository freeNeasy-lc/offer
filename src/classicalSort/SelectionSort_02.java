package classicalSort;

import java.util.Arrays;

/**
 * 选择排序
 *首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort_02 {
    public static void selectionSort(int[] array) {
        if (array == null || array.length<=1) {
            return;
        }
        for (int i=0 ; i<array.length -1; i++) {
            int minIndex=i;
            for (int j=i+1; j<array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i!=minIndex) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
