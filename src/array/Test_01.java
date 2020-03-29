package array;

public class Test_01 {
    public static void main(String args[]) {
        int target = 13;
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        TwoArrayFind_01 taf = new TwoArrayFind_01();
        boolean tag = taf.Find1(target, array);
        System.out.println(tag);
    }
}
