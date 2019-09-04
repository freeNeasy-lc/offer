package array;

public class Test {
    public static void main(String args[]) {
        int target = 9;
        int[][] array = {{1,4,6}, {2,5,6}, {5,8,9}};
        TwoArrayFind taf = new TwoArrayFind();
        boolean tag = taf.Find(target, array);
        System.out.println(tag);
    }
}
