package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/1/17.
 */
public class AppendFile {

    public static List<String> readFile(File inputFile) {
        try (FileReader fr = new FileReader(inputFile); BufferedReader br = new BufferedReader(fr)) {
            List<String> filedata = new ArrayList<>();
            String data;
            while ((data = br.readLine()) != null) {
                filedata.add(data);
            }
            return filedata;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void appendFile(List<String> file1Data, List<String> file2Data, File result) {
        try (FileWriter fw = new FileWriter(result, false); BufferedWriter bw = new BufferedWriter(fw)) {
            for (String s : file1Data) {
                bw.write(s);
                bw.newLine();
            }
            for (String s : file2Data) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        File file1 = new File(("A.txt"));
        File file2 = new File("B.txt");
        File result = new File("C.txt");

        List<String> file1Data = readFile(file1);
        List<String> file2Data = readFile(file2);

        System.out.println("file1 content");
        file1Data.forEach(System.out::println);

        System.out.println("file2 content");
        file2Data.forEach(System.out::println);

        System.out.println("Appending");
        appendFile(file1Data, file2Data, result);
        System.out.println("completed");


    }

}
