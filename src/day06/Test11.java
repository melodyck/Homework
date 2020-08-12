package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 * @author Bonnie
 *
 */
public class Test11 {
    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("./src/day06/");
        ArrayList<Emp> emps = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
            emps.add(emp);
        }
        emps.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.println(emps);
    }
}
