package array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray_13 {
    //冒泡 O(n^2)
    private static void reOrderArray1(int[] array) {
        boolean tag = true;
        for (int i=0; i<array.length && tag; i++) {
            tag = false;
            for (int j=0; j<array.length-1-i; j++) {
                //左边是偶数，右边是奇数的情况交换
                if ((array[j]&1)==0 && (array[j+1]&1)==1) {
                    tag = true;
                    int tmp =array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    //插入法O(n^2)
    //与运算,只有都是1，结果才是1，奇数&1=1，偶数&1=0
    private static void reOrderArray2(int[] array) {
        int j,key;
        for (int i=1; i<array.length;i++) {
            key = array[i];
            if ((key&1)==0) continue;//如果是偶数跳过
            j = i - 1;
            //将奇数插在已遍历的所有偶数前边
            while(j>=0 && (array[j]&1)==0) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    //归并法，nlog(n)
    private static void reOrderArray3(int[] array) {
        mergeSort(array,0,array.length-1);
    }
    /**
     * 归并排序，合并排序
     * @param arr 要排序的数组
     * @param p 左边索引
     * @param r 右边索引
     */
    public static void mergeSort(int[] arr, int p, int r){
        // 递归实现归并排序
        if(p<r){
            int q = (p+r)/2;
            mergeSort(arr, p, q);
            mergeSort(arr, q+1, r);
            merge(arr, p, q, r); //上面的合并算法
        }
    }
    /**
     * 合并
     */
    public static void merge(int[] arr, int p, int q, int r){
        // arr是数组，p，q，r为下标。 p-q 和 q-r 为已经排好序的两个堆（不带哨兵）
        int n1 = q-p+1; // [p-q]左边元素的个数,q元素归左边
        int n2 = r-q; // (q-r]右边元素个数
        int[] L = new int[n1];
        int[] R = new int[n2];
        // arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        // src：要复制的数组(源数组)
        // srcPos：复制源数组的起始位置
        // dest：目标数组
        // destPos：目标数组的下标位置
        // length：要复制的长度
        System.arraycopy(arr, p, L, 0, n1);
        System.arraycopy(arr,q+1,R,0,n2);
        for(int k=p,i=0,j=0; k<=r; k++){
            if(i==n1)
                arr[k] = R[j++]; // 左边已经到头了
            else if(j==n2)
                arr[k] = L[i++]; // 右边已经到头了
            else if((L[i]&1)==1 || ((L[i]&1)==0 && (R[j]&1)==0))
                arr[k] = L[i++]; // 左边是奇数(或者左右都是偶数时) 的话左边放入数组
            else
                arr[k] = R[j++]; // 否则右边放入
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,42,34,54,7,12,4,8,9,24};
        reOrderArray3(array);
        for (int i = 0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
