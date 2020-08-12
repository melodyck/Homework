package correction;

import java.io.*;

public class intersectRead {
    public static void main(String[] args) throws IOException {
        FileReader fra = new FileReader("./src/correction/a.txt");
        FileReader frb = new FileReader("./src/correction/b.txt");
        FileWriter fwc = new FileWriter("./src/correction/c.txt", true);
        BufferedReader bfa = new BufferedReader(fra);
        BufferedReader bfb = new BufferedReader(frb);
        BufferedWriter bwc = new BufferedWriter(fwc);
        String a, b;
        while ((a = bfa.readLine()) != null && (b = bfb.readLine()) != null){
            if(a != null){
                bwc.write(a);
                bwc.flush();
            }
            if(b != null){
                String[] word = b.split(" ");
                for (String w: word){
                    bwc.write(w);
                    bwc.flush();
                }
            }
        }
    }
}
