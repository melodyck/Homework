package day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入文件名:");
        StringBuilder name = new StringBuilder(console.nextLine());
        name.insert(0, "./src/day06/");
//        name.replace(12, name.length(),"test_副本1.txt");
//        System.out.println(name);

        System.out.println(create(name) + "文件创建成功");
    }
    private static int i = 0;
    public static StringBuilder create(StringBuilder name) throws IOException {
        File file = new File(name.toString());
        if(!file.createNewFile()){
            i++;
            System.out.println(name + "文件已存在");
            create(name.replace(12, name.length(),"test_副本" + i +".txt"));
        }
        i = 0;
        return name;
    }
}
