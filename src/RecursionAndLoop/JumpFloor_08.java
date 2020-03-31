package RecursionAndLoop;
/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
1种跳法 第一阶：1
2种跳法 第二阶：1+1 2
3种跳法 第三阶：1+1+1 1+2 2+1
5种跳法 第四阶：1+1+1+1 2+2 1+2+1 2+1+1 1+1+2
本质上还是斐波那契数列
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
}
