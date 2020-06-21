package findAndSort;

/*
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class minNumberInRotateArray_06 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) {
            return 0;
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i+1] < array[i]) {
                return array[i+1];
            }
        }
        return 0;
    }

    //二分法
    public int minNumberInRotateArray1(int [] array) {
        int start = 0;
        int end = array.length-1;
        int mid = 0;
        while(array[start] >= array[end]) {
            if(end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end)/2;
            if(array[mid] >= array[start]) {
                start = mid;
            }else if (array[mid] <= array[end]) {
                end = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        minNumberInRotateArray_06 number = new minNumberInRotateArray_06();
        int [] array = {3,4,5,1,2};
        int aaa = number.minNumberInRotateArray1(array);
        System.out.println(aaa);
    }
}
