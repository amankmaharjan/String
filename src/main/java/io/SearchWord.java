package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aman on 6/1/17.
 */
public class SearchWord {

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

//    public static void writeFile(File outputFile, List<String> fileData) {
//        try (FileWriter fw = new FileWriter(outputFile, false); BufferedWriter bw = new BufferedWriter(fw)) {
//            for (String s : fileData) {
//                bw.write(s);
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static int search(String keyword, List<String> dataFile) {
        int count = 0;
        for (String s : dataFile) {
            String[] perLineWords = s.replaceAll(",", "").split("\\s+|\t");
            System.out.println(perLineWords.length);
            for (String word : perLineWords) {
                System.out.print(word);
                System.out.print(" ");
                if (word.equalsIgnoreCase(keyword))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        File file1 = new File(("abc.txt"));
        File file2 = new File("B.txt");
        File result = new File("C.txt");

        System.out.println("keyword to search:");
        String keyworod = scan.next();

        List<String> file1Data = readFile(file1);
        System.out.println("to:" + search("keyword", file1Data));

    }
}
