package array;

import sun.font.TrueTypeFont;

/*
    二维数组中的查找
    题目描述：
    在一个二维数组中（每个一维数组的长度相同），
    每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
//你写的这个没有利用到二维数组行列递增顺序排列，复杂度太高
public class TwoArrayFind_01 {
    public boolean Find(int target, int[][] array) {
        /*for (int[] i : array) {
            for (int j : i) {
                if (target == j) {
                    return true;
                }
            }
        }
        return false;*/
        for (int i = 0; i<array.length; i++) {
            for (int j = 0; j<array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 思路一：
     * 这个每一行刚好都是有序递增的，把每一行看成有序递增的数组
     * 利用二分查找
     * 通过遍历每一行的答案
     * 时间复杂度是nlogn
     * @param target
     * @param array
     * @return
     */
    public boolean Find1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int start = 0;
            int end = array[i].length-1;
            // start <= end 注意目标数字在开头的情况
            while(start <= end) {
                int mid = (start + end) / 2;
                if (target > array[i][mid]) {
                    start = mid + 1;
                }else if (target < array[i][mid]) {
                    end = mid - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 思路二：
     * 利用二维数组由上到下，由左到右递增的规律，并且每个一维数组长度相同！
     * 选取右上角或者左下角的元素array[row][col]与target进行比较
     * 右上角：
     * 当target小于元素array[row][col]时，target在元素array所在行的左边。
     * 当target大于元素array[row][col]时，target在元素array所在列的下边。
     * 左下角：
     * 当target小于元素array[row][col]时，target在元素array所在列的上边。
     * 当target大于元素array[row][col]时，target在元素array所在行的右边。
     * 时间复杂度m+n
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int[][] array) {
        int row = 0;
        int col = array[0].length-1;
        while(row <= array.length-1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            }else if (target > array[row][col]) {
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}
