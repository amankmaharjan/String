package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aman on 6/1/17.
 */
public class WordCounter {

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
//            System.out.println(perLineWords.length);
            for (String word : perLineWords) {
                System.out.print(word);
                System.out.print(" ");
                if (word.equalsIgnoreCase(keyword))
                    count++;
            }
        }

        return count;
    }
//    public static List<String> getwordsArray(File inputFile) {
//        try (FileReader fr = new FileReader(inputFile); BufferedReader br = new BufferedReader(fr)) {
//            String data;
//            while ((data = br.read()) != null) {
//
//            }
//            return filedata;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static void join(List<String> dataFile) {
        List<String> delimeteredList = new ArrayList<>();
        StringBuffer delimetedline=new StringBuffer();

        for (String s : dataFile) {
            String[] perLineWords = s.replaceAll(",", "").split("\\s+|\t");
            for (String word : perLineWords) {
                delimetedline.append(String.join("*",word));
                System.out.println(delimetedline);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file1 = new File(("abc.txt"));
        File file2 = new File("B.txt");
        File result = new File("C.txt");

//        System.out.println("enter keyword to search:");
//        String keyword = scanner.next();
        List<String> file1Data = readFile(file1);
//        System.out.println("\n" + keyword + ":" + search(keyword, file1Data));

        join(file1Data);
    }

}
