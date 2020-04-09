package recursionAndLoop;
/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
1种跳法 第一阶：1
2种跳法 第二阶：1+1 2
3种跳法 第三阶：1+1+1 1+2 2+1
5种跳法 第四阶：1+1+1+1 2+2 1+2+1 2+1+1 1+1+2
本质上还是斐波那契数列
分析：青蛙每次只有一阶或者两阶两种跳法，那么：

假设第一次跳的是一阶，那么剩下的n-1个台阶，跳法是f(n-1)
假设第一次跳的是两阶，那么剩下的n-2个台阶，跳法是f(n-2)
由上面两种假设可得：f(n) = f(n-1) + f(n-2)
由实际情况可知：f(1) = 1，f(2) = 2
最终得出的是一个斐波那契数列：
                 |  1，n = 1

f(n)   =       |  2, n = 2

                 |  f(n-1) + f(n -2), n >2
 */
public class JumpFloor_08 {
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int start = 1;
        int end = 2;
        for(int i = 3; i <= target; i++) {
            int tmp = start + end;
            start = end;
            end = tmp;
        }
        return end;
    }
    //推荐
    public int JumpFloor1(int target) {
        if (target <= 2) {
            return target;
        }
        int sum = 1;
        int one = 1;
        for (int i = 2; i<=target; i++) {
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }
}
