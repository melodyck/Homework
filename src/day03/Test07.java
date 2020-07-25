package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * 要求用户首先输入员工数量，然后输入相应员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 每一行为一个员工信息，然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 在解析成Emp对象后要先查看当前集合是否包含该员工，若包含则提示该用于已存在，
 * 否则才存入集合。
 * 然后输出集合查看每个员工信息.
 * @author Bonnie
 *
 */
public class Test07 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        Collection<Emp> col = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("请输入员工数量:");
        int n = console.nextInt();
        System.out.println("请输入员工信息 例如:\n张三,25,男,5000,2006-02-15");
        for (int i = 0; i < n; i++) {
            String s = console.next();
            String[] info = s.split(",");
            Emp emp = new Emp(info[0], Integer.parseInt(info[1]), info[2],Integer.parseInt(info[3]), dateFormat.parse(info[4]));
            if(col.contains(emp)){
                System.out.println("该员工已存在请重新输入");
                i--;
                continue;
            }
            col.add(emp);
        }
        System.out.println(col);
    }
}
