package recursionAndLoop;
/*
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
f(n) = {        0           n=0,
                1           n=1,
       f(n)=f(n-1) + f(n-2) n>1
       }
n<=39
 */
public class Fibonacci_07 {
    public int Fibonacci_07 (int n) {
        if(n<=1){
            return n;
        }
        return Fibonacci_07(n-1) + Fibonacci_07(n-2);
    }

    public int Fibonacci (int n) {
        if (n < 2) {
            return n;
        }
        // mid作为中间变量存起来
        int end = 0;
        int start = 1;
        // i理解为n-1
        // i end start
        // 0  0   1
        // 1  1   0
        // 2  1   1
        // 3  2   1
        // 4  3   2
        // 5  5   3
        for(int i = 0; i < n; i++) {
            int tmp = end + start;
            start = end;
            end = tmp;
        }
        return end;
    }

    //推荐方式
    public int Fibonacci1 (int n) {
        if (n < 2) {
            return n;
        }

        int sum = 1;
        int one = 0;
        for(int i = 2; i <= n; i++) {
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }
    public static void main(String[] args) {
        Fibonacci_07 Fibonacci_07 = new Fibonacci_07();
        //0 1 1 2 3 5 8
        int n = Fibonacci_07.Fibonacci(5);
        System.out.println(n);
    }
}