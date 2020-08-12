package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
 * 即:输入名字"张三"
 * 若该员工存在，则输出如下格式:
 * 张三,25,5000,2006-02-14
 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
 * 若该员工不存在，则输出:"查无此人"
 * @author Bonnie
 *
 */
public class Test12 {
    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("./src/day06/");
        Map<String, Emp> map = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner console = new Scanner(System.in);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".emp");
            }
        });
        for (File f: files){
            System.out.println(f.getName());
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String information = bfr.readLine();
            String[] info = information.split(",");
            Emp emp = new Emp(info[0], Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), dateFormat.parse(info[4]));
            map.put(emp.getName(), emp);
        }
        System.out.println("请输入员工名字");
        String name = console.next();
        Emp emp;
        Calendar anniversary = Calendar.getInstance();
        if((emp = map.get(name)) != null){
            anniversary.setTime(emp.getHiredate());
            anniversary.add(Calendar.YEAR, 20);
            anniversary.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            System.out.println(emp);
            System.out.println("入职20周年纪念日派对日期: " + dateFormat.format(anniversary.getTime()));
        }else {
            System.out.println("查无此人");
        }
    }
}
