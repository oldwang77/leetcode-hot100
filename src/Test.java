import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str="ADFCE";
        char[] arrayCh=str.toCharArray();
        Arrays.sort(arrayCh);
        String sortedStr=new String(arrayCh);
        System.out.println(sortedStr);

        // 这样子写是错误的
        // String s = arrayCh.toString();
        // System.out.println(s);
    }
}
