package RecursionAndLoop;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(n)=f(n-1)+f(n-2)+...+f(1)
 * f(n-1)=f(n-2)+...f(1)
 * 得:f(n)=2*f(n-1)
 * 1 1 1
 * 2 2 1+1 2
 * 4 3 1+1+1 1+2 2+1 3
 * 8 4 1+1+1+1 1+2+1 2+1+1 1+1+2 2+2 3+1 1+3 4
 * 16 5 1+1+1+1+1 1+4 4+1 1+3+1 3+1+1 1+1+3 1+2+2 2+2+1 2+1+2 1+1+1+2 1+1+2+1 1+2+1+1
 *  2+1+1+1 2+3 3+2 5
 */
public class JumpFloorII_09 {
    public int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int sum = 2;
        for (int i=2; i< target; i++) {
            sum = sum *2;
        }
        return sum;
    }
}
