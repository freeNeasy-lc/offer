package recursionAndLoop;
/*
题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
比如n=3时，2*3的矩形块有3种覆盖方法：

n=1 1种
n=2 2种
n=3 3种
n=4 5种
 */
public class RectCover_10 {
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int sum = 1;
        int one = 1;
        for (int i=2; i <= target; i++) {
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }
}
