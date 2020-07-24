package day02;

import java.util.Scanner;

/**
 * 输入一个数学计算表达式，如:1+2
 * 然后输出计算后的结果:1+2=3
 * 这里计算表达式只计算一次即可，可以使用加减乘除任意一个,可以进行小数运算。
 * @author Bonnie
 *
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();
        double result = 0;
        if(s.indexOf("+") > 0){
            String[] num = s.split("\\+");
            result = Double.parseDouble(num[0]) + Double.parseDouble(num[1]);
        }
        else if(s.indexOf("-") > 0){
            String[] num = s.split("\\-");
            result = Double.parseDouble(num[0]) - Double.parseDouble(num[1]);
        }
        else if(s.indexOf("*") > 0){
            String[] num = s.split("\\*");
            result = Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
        }
        else if(s.indexOf("/") > 0){
            String[] num = s.split("\\/");
            result = Double.parseDouble(num[0]) / Double.parseDouble(num[1]);
        }
        System.out.println(result);
    }
}
