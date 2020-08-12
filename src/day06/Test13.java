package day06;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后输出该集合中每个员工信息。
 * 该文件800字节，每80个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为int,长度为4个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为字符串，格式"yyyy-MM-dd"，长度为30个字节，编码为:UTF-8
 * 格式可参考当前包中emp.jpg图
 * 提示:
 * 使用RandomAccessFile读取字符串时，例如name,可以先读取32个字节，再按照UTF-8
 * 转换为字符串，读取age时可以直接使用readInt方法。依次类推。
 * @author Bonnie
 *
 */
public class Test13 {
	public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
		//使用类加载器加载当前包中的emp.dat文件
		File file = new File(Test13.class.getClassLoader().getResource("day06/emp.dat").toURI());
		System.out.println(file.getAbsolutePath());
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		byte[] name = new byte[32];
		byte[] gender = new byte[10];
		byte[] hiredate = new byte[30];
		ArrayList<Emp> emps = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String names = new String(name);
		int age = 0;
		String genders = null;
		int salary = 0;
		Date hiredates = null;
		while (raf.read(name) == name.length){
			for (int i = 0; i < 5; i++) {
				switch (i){
					case 0:
						names = new String(name);
						break;
					case 1:
						age = raf.readInt();
						break;
					case 2:
						raf.read(gender);
						genders = new String(gender);
						break;
					case 3:
						salary = raf.readInt();
						break;
					case 4:
						raf.read(hiredate);
						hiredates = dateFormat.parse(new String(hiredate));
						break;
					default:
						break;
				}
			}
			Emp emp = new Emp(names, age, genders, salary, hiredates);
			emps.add(emp);
		}
		System.out.println(emps);
	}
}
