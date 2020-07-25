package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
 * 所在周的周三的日期。
 * 例如:
 * 出生日期:1992-07-15。
 * 20岁生日:2012-07-15
 * 当周的周三为:2012-07-18
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) throws ParseException {
        Scanner console =  new Scanner(System.in);
        String regex = "^\\d{17}[\\dXx]$";//身份证:^\d{17}[\dXx]$
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("请输入身份证号:");
        String num = console.next();
        while (!num.matches(regex)){
            System.out.println("格式错误请重新输入");
            num = console.next();
        }
        Date birth = dateFormat.parse(num.substring(6, 14));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birth);
        System.out.println("出生日期:" + dateFormatOut.format(birth));
        calendar.add(Calendar.YEAR, 20);
        System.out.println("20岁生日:" + dateFormatOut.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        System.out.println("当周的周三为:" + dateFormatOut.format(calendar.getTime()));
    }
}
