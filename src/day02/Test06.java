package day02;

import java.util.Scanner;

/**
 * 测试正则表达式，并尝试编写规则: 电话号码可能有3-4位区号，
 * 7-8位号码:0415-5561111
 * @author Bonnie
 *
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String phone = console.nextLine();
        String regex = "^\\d{3,4}\\-\\d{7,8}$";//电话号码的正则表达式^\d{3,4}\-\d{7,8}&
        System.out.println("格式是否正确:" + phone.matches(regex));
    }
}
