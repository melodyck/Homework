package day06;

import java.io.*;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
 * @author Bonnie
 *
 */
public class Test07 {
	public static void main(String[] args) throws IOException {
		Scanner console = new Scanner(System.in);
		System.out.println("请输入文件名:");
		String name = console.nextLine();
//		StringBuilder names = new StringBuilder(name);
//		String[] s = name.split("\\.");
//		System.out.println(s[0]);
//		names.insert(s[0].length(),"_copy");
//		System.out.println(names);
		copy2(name);
	}
	/**
	 * 使用单字节方式复制
	 * @param name 要复制的文件名
	 */
	public static void copy1(String name) throws IOException {
		StringBuilder names = new StringBuilder(name);
		String[] s = name.split("\\.");
		names.insert(s[0].length(),"_copy");
		//输出字节流给副本
		FileOutputStream os = new FileOutputStream("E:\\ideaWorkplace\\Homework/src/day06/" + names, true);
		//从正本读取字节流
		FileInputStream is = new FileInputStream("E:\\ideaWorkplace\\Homework/src/day06/" + name);
		int i;
		//逐个字节读取复制
		while ((i = is.read()) != -1){
			os.write(i);
		}
//		流的关闭原则：先开后关，后开先关。
		is.close();
		os.close();
	}
	/**
	 * 使用字节数组形式复制
	 * @param name 要复制的文件名
	 */
	public static void copy2(String name) throws IOException {
		StringBuilder names = new StringBuilder(name);
		String[] s = name.split("\\.");
		names.insert(s[0].length(),"_copy");
		//输出字节流给副本
		FileOutputStream os = new FileOutputStream("E:\\ideaWorkplace\\Homework/src/day06/" + names, true);
		//从正本读取字节流
		FileInputStream is = new FileInputStream("E:\\ideaWorkplace\\Homework/src/day06/" + name);
		//读取byte数组长度的字节
		byte[] b = new byte[3];//一次读取4字节可能会出现乱码,因为utf-8编码一个字为三个字节,所以最好一次读3个字节
		int len;
		//当读取字节数为-1时表示读取到了末尾
		while ((len = is.read(b)) != -1){
			//将每次读取的有效字节写入
			os.write(b, 0, len);
		}
		os.close();
		is.close();
	}
}
