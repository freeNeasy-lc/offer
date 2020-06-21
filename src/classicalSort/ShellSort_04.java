package classicalSort;

import java.util.Arrays;

//希尔排序
public class ShellSort_04 {
    public static void shellSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;

        // tmp为临时变量，gap增量默认是长度的一半
        // 每次变为之前的一半，直到最终数组有序
        int tmp, gap = length / 2;

        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                // 将当前的数与减去增量之后位置的数进行比较，如果大于当前数，将它后移
                tmp = array[i];
                int preIndex = i - gap;

                while (preIndex >= 0 && array[preIndex] > tmp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                // 如果没有发生移动，preIndex+gap=i,无变化
                // 如果发生移动， preIndex -= gap,则preIndex+gap=preIndex-gap+gap=i-gap
                // 当前数array[i]替换array[i-gap]
                array[preIndex + gap] = tmp;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}