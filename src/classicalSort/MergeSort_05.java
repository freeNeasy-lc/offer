package classicalSort;

import java.util.Arrays;

//归并排序
public class MergeSort_05 {
    public static void mergeSort(int[] array) {
        if(array==null || array.length<=1) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right-left) >> 1);
        // 对左侧子序列进行递归排序
        sort(array, left, mid);
        // 对右侧子序列进行递归排序
        sort(array, mid + 1, right);
        // 合并
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int i=0;
        int p1=left;
        int p2=mid+1;
        // 比较左右两部分的元素，哪个小，把那个元素填入tmp中
        while (p1 <= mid && p2 <= right) {
            tmp[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到tmp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            tmp[i++] = array[p1++];
        }
        while (p2 <= right) {
            tmp[i++] = array[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < tmp.length; i++) {
            array[left + i] = tmp[i];
        }
    }
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
