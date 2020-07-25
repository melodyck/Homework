package day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 然后输出每个员工的转正仪式日期。
 * 转正仪式日期为:入职3个月的当周周五
 * 
 * @author Bonnie
 *
 */
public class Test09 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工信息,格式为：\nname,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....");
        String information = console.nextLine();
        String[] info = information.split(";");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Emp> list = new ArrayList<>();
        for (String personalInfo:info
             ) {
            String[] personalInfoList = personalInfo.split(",");
            Emp emp = new Emp(personalInfoList[0], Integer.parseInt(personalInfoList[1]), personalInfoList[2],
                    Integer.parseInt(personalInfoList[3]), format.parse(personalInfoList[4]));
            list.add(emp);
        }
        for (Emp emp:list
             ) {
            System.out.println(emp);
        }
        for (Emp emp:list
             ) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(emp.getHiredate());
            calendar.add(Calendar.MONTH, 3);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            System.out.println(emp.getName() + "的转正日期为" + format.format(calendar.getTime()));
        }
    }
}
