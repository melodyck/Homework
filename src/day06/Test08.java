package day06;

import java.io.*;
import java.util.Arrays;

/**
 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
 * 然后将其分别读取出来并输出
 * @author Bonnie
 *
 */
public class Test08 {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/day06/raf.dat");
        RandomAccessFile raf = new RandomAccessFile(file, "rw" );
        raf.writeInt(Integer.MAX_VALUE);
        raf.writeLong(Long.MAX_VALUE);
        raf.seek(0);
        System.out.println(raf.readInt());
        System.out.println(raf.readLong());
//        System.out.println(is.);
    }
}
