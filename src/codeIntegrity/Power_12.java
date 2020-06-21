package codeIntegrity;
/*
题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
 */
public class Power_12 {
    public double Power(double base, int exponent) {
        //x^-2可以转换成(1/x)^2
        if (exponent < 0){
            base = 1/base;
            exponent = -exponent;
        }

       if (exponent == 0)
           return 1;
       if (exponent == 1)
           return base;
       double result = Power(base, exponent>>1);
       result *= result;
       if ((exponent & 1) != 0) {
           result *= base;
       }
       return result;
    }

    public static void main(String[] args) {
        Power_12 p = new Power_12();
        double b = p.Power(2,-2);
        System.out.println(b);
    }
}
