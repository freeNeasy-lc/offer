package array;

import java.util.ArrayList;
import java.util.Iterator;

/*
    顺时针打印矩阵
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class printMatrix_19 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return  list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true) {
            // 最上面一行
            for (int col = left; col<=right; col++) {
                list.add(matrix[up][col]);
            }
            up++;
            if (up > down) {
                break;
            }
            // 最右边一行
            for (int row=up; row<=down; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            // 最下面一行
            for (int col=right; col>=left; col--) {
                list.add(matrix[down][col]);
            }
            down--;
            if (up > down) {
                break;
            }
            // 最左边一行
            for (int row=down; row>=up; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] matrix1 = {{1,2},{3,4}};
        //ArrayList遍历
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println("1.for循环的遍历方式：");
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("2.foreach的遍历方式：");
        for (Integer index : list) {
            System.out.println(index);
        }
        System.out.println("3.Iterator的遍历方式：");
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
