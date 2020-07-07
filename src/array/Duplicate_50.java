package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//数组中重复的数字
public class Duplicate_50 {

    //排序 时间复杂度:nlog(n)
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
       if (numbers == null || length == 0) {
           return false;
       }

        Arrays.sort(numbers);
       for (int i=0; i < length - 1; i++) {
           if (numbers[i] == numbers[i+1]) {
               duplication[0] = numbers[i];
               return true;
           }
       }
       return false;
    }

    //利用HashSet解决,时间复杂度o(n)
    public static boolean duplicate1(int numbers[],int length,int [] duplication) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }else {
                set.add(numbers[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = {2,1,1,3,0,4};
        int[] duplication = new int[1];
        boolean tag = duplicate1(array, 5, duplication);
        System.out.println(tag);
    }
}
