package io;

import java.io.*;

/**
 * Created by aman on 6/1/17.
 */
public class Buffered {
    public static void main(String[] args) {
        File file = new File("buffered.txt");
        FileWriter fw = null;
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);

            bw.write("hRAM");
            bw.write("\n");
            bw.write("hello");
            bw.close();

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String c;
            while ((c = br.readLine()) != null) {
                System.out.println(c);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
