package string;

public class Test {
    public static void main(String args[]) {
        ReplaceSpace res = new ReplaceSpace();
        String str1 = "asdasdas";
        Boolean bool = res.stringFind(str1);
        System.out.println(bool);
        StringBuffer str = new StringBuffer("we are hero and you ");
        String result = res.replaceSpace2(str);
        System.out.println(result);
    }
}
