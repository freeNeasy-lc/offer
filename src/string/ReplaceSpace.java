package string;
/*
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace1(StringBuffer str){
        //全部替换复杂度O(n*n)
        String string = str.toString();
        String result = string.replaceAll("\\s", "%20");
        return result;
    }

   /* public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        char[] strChar = string.toCharArray();
        int length = string.length();
        int i = 0;
        if (strChar == null && length < 0) {
            return "错误";
        }
        //实际长度，就是字符串原来的长度
        int trueLength = 0;
        //空格数目
        int numBlank = 0;
        //java不能通过'\0'判断是否到达末尾，会报数组越界异常
        while(strChar[i] != '\0') {
            ++trueLength;
            if(strChar[i] == ' ') {
                ++numBlank;
            }
            ++i;
        }
        //把空格替换为%20后的长度，
        int newLength = trueLength + numBlank * 2;
        int index = trueLength;
        int indexOfNew = newLength;
        while(index >= 0 && indexOfNew > index) {
            if (strChar[index] == ' ') {
                strChar[indexOfNew--] = '0';
                strChar[indexOfNew--] = '2';
                strChar[indexOfNew--] = '%';
            }
            else {
                strChar[indexOfNew--] = strChar[index];
            }
            --index;
        }
        return strChar.toString();
    }*/

   //复杂度只有o(n)
   public String replaceSpace2(StringBuffer str) {
       int numBlank = 0;
       for (int i = 0; i < str.length(); i++) {
           //charAt()返回指定索引的字符
           if(str.charAt(i) == ' ')
               ++numBlank;
       }
       int oldIndex = str.length() - 1;
       int newLength = str.length() + numBlank * 2;
       //setLength()设置字符串长度
       str.setLength(newLength);
       int newIndex = newLength - 1;
       for(;oldIndex >= 0 && oldIndex < newIndex; oldIndex--) {
           if(str.charAt(oldIndex) == ' ') {
               //setCharAt()修改所引出的字符
               str.setCharAt(newIndex--,'0');
               str.setCharAt(newIndex--,'2');
               str.setCharAt(newIndex--,'%');
           }else
               str.setCharAt(newIndex--,str.charAt(oldIndex));
       }
       return str.toString();
   }

   //判断字符串末尾的'\0'
   public Boolean stringFind(String str) {
       for(int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == '\0') {
               return true;
           }
       }
       return false;
   }
}
