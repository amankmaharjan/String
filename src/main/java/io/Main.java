package io;

import java.io.IOException;

/**
 * Created by aman on 5/31/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//
//        File file = new File("test.txt");
//        FileWriter fw = new FileWriter(file, false);
//        fw.write("hRAM");
//        fw.write("\n");
//        fw.append("aman");
//        fw.close();
//
//        FileReader fr = new FileReader(file);
//        int c;
//        while ((c = fr.read()) != -1) {
//            System.out.print((char) c);
//        }
//        fr.close();

        long x = -2147483648L;
        int y;
        if (x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE) {
            y = (int) x;
        } else {
            y = Integer.parseInt((String) String.valueOf(x).subSequence(0, 9));
        }
        System.out.println(y);


//        String str="sdfvsdf68fsdfsf8999fsdf09";
//        String numberOnly= str.replaceAll("[^0-9]", "");
//        System.out.println(numberOnly);
    }
}

