package bitOperate;

/*
题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1_11 {
    //方法1：暴力解法
    public int NumberOf1(int n) {
        //把一个10进制数转为32位的2进制数。同时对负数，会用补码表示
        String s = Integer.toBinaryString(n);
        String[] split = s.split("");
        int a = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("1")) {
                a++;
            }
        }
        return a;
    }

    //方法2：常规解法
    // 数字n和1做与运算，判断n的最低位是不是1。
    // 接着把1左移一位得到2，再和n做与运算，就能判断n的次低位是不是1
    // 反复左移，每次都能判断n的其中一位是不是1,从而计算1的个数
    public int NumberOf2(int n) {
        int num = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }

    // 方法3：最优解法
    // 把一个整数减1，再和原整数做与运算，会把该整数最右边一个1变为0
    // 一个整数的二进制有多少个1，就可以进行多少次这样的操作
    public int NumberOf3(int n) {
        int num = 0;
        while (n != 0){
            num++;
            n = n & (n-1);
        }
        return num;
    }

    public static void main(String[] args) {
        NumberOf1_11 number = new NumberOf1_11();
        int num = number.NumberOf1(100);
        System.out.println(num);
    }
}
