package offer;

public class Test_65 {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public static void main(String[] args) {
        Test_65 test = new Test_65();
        int add = test.add(12, 10);
        System.out.println(add);
    }
}
