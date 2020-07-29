package day05;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
 * 并对集合排序，然后输出每个员工信息。
 * 
 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
 * 输出每个员工的信息。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        System.out.println("输入若干员工信息，格式为：\n" +
                "name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....\n" +
                "例如:\n" +
                "张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...");
        String s = console.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Emp> list = new ArrayList<>();
        String[] person = s.split(";");
        for(String info: person){
            String[] infoList = info.split(",");
            Emp emp = new Emp(infoList[0], Integer.parseInt(infoList[1]), infoList[2],
                    Integer.valueOf(infoList[3]), format.parse(infoList[4]));
            list.add(emp);
        }
        Collections.sort(list);
        System.out.println("默认排序");
        for(Emp emp: list){
            System.out.println(emp);
        }
        list.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o2.getHiredate().compareTo(o1.getHiredate());
            }
        });
        System.out.println("按照入职时间排序,降序排列");
        for(Emp emp: list){
            System.out.println(emp);
        }
//        System.out.println(list);
    }
}
