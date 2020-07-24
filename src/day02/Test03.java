package day02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入一个IP地址，然后将4段数字分别输出
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();
        String[] strs = s.split("\\.");
        for(String str: strs){
            System.out.println(str);
        }
    }
}
