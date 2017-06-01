package io;

import java.io.*;

/**
 * Created by aman on 6/1/17.
 */
public class CountLetter {

    static File inputFile = new File("xanadu.txt");
    static File outputFile = new File(" count.txt");


    public static StringBuffer readFile() {
        try (FileReader fr = new FileReader(inputFile); BufferedReader br = new BufferedReader(fr)) {
            StringBuffer filedata = new StringBuffer();
            String data;
            while ((data = br.readLine()) != null) {
                filedata.append(data);
                filedata.append("\n");
            }
            return filedata;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(int count) {
        try (FileWriter fw = new FileWriter(outputFile, false); BufferedWriter bw = new BufferedWriter(fw)) {
            fw.write("a:" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int count(char value, String filedata) {
        int count = 0;
        for (int i = 0; i < filedata.length(); i++) {
            if (filedata.charAt(i) == value)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {



        String filedata = new String(readFile());
        System.out.println(filedata);
        int countA = count('a', filedata);
        writeFile(countA);

        System.out.println("a:" + countA);
    }
}
