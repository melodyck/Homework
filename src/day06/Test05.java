package day06;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String f = console.nextLine();
        File file = new File(f);
        deleteFile(file);
    }
    public static void deleteFile(File file){
        File[] files = file.listFiles();
        if(file.isDirectory()){
            for(File f: files){
                deleteFile(f);
            }
        }
        file.delete();
    }
}