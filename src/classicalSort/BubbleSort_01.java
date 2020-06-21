package classicalSort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 算法描述
 *
 * - 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * - 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * - 针对所有的元素重复以上的步骤，除了最后一个；
 * - 重复步骤1~3，直到排序完成。
 */
public class BubbleSort_01 {
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;

        //外层循环控制比较轮数i
        for (int i=0; i<length; i++) {
            // 内层循环控制每一轮比较次数，每进行一轮排序都会找出一个较大值
            // (array.length - 1)防止索引越界，(array.length - 1 - i)减少比较次数
            for (int j=0; j< length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
