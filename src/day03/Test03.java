package day03;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String regex = "^\\d{4}\\-\\d{2}\\-\\d{2}$";//^\d{4}\-\d{2}\-\d{2}$

        System.out.println("输入某人生日，格式为\"yyyy-MM-dd\"");
        String birth = console.nextLine();
        while (!birth.matches(regex)){
            System.out.println("格式错误请重新输入");
            birth = console.nextLine();
        }
        String[] info = birth.split("\\-");
//        System.out.println(Arrays.toString(info));
        Calendar birthday = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        birthday.set(Calendar.YEAR, Integer.parseInt(info[0]));
        birthday.set(Calendar.MONTH, Integer.parseInt(info[1]) - 1);
        birthday.set(Calendar.DAY_OF_MONTH, Integer.parseInt(info[2]));
        int week = (int)((calendar.getTimeInMillis() - birthday.getTimeInMillis()) / (7l * 24 * 60 * 60 * 1000));
        System.out.println("经过了:" + week);
    }
}
