package day06;

import java.io.*;
import java.util.Scanner;

/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。
 * @author Bonnie
 *
 */
public class Test09 {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/day06/note.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        System.out.println("请输入文本:  输入exit退出");
        Scanner console = new Scanner(System.in);
        String s;
        while (!(s = console.nextLine()).equals("exit")){
            fw.write(s + "\n");
            fw.flush();
        }
        fw.close();
    }
}
