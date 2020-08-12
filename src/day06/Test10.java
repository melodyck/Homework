package day06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 要求用户输入一个员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 然后将输入的员工信息解析成Emp对象。
 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。

 * @author Bonnie
 *
 */
public class Test10 {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println( "格式:\n" + "张三,25,男,5000,2006-02-15\n" + "请输入员工信息:  " + "  输入exit退出");
        String s;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (!(s = console.nextLine()).equals("exit")) {
            String[] info = s.split(",");
            Emp emp = new Emp(info[0], Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), dateFormat.parse(info[4]));
            File file = new File("./src/day06/" + info[0] + ".emp");
            FileWriter fw = new FileWriter(file);
            fw.write(emp.toString());
            fw.flush();
        }
    }
}
