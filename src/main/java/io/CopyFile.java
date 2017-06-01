package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aman on 6/1/17.
 */
public class CopyFile {


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

    public static void writeFile(File outputFile, List<String> fileData) {
        try (FileWriter fw = new FileWriter(outputFile, false); BufferedWriter bw = new BufferedWriter(fw)) {
            for (String s : fileData) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter source file name:with extension like source.txt:");
        String source = scan.nextLine();
        System.out.println("Enter destination file name:with extension like destination.txt:");
        String destination = scan.nextLine();

        System.out.println("source content:");
        List<String> filedata = readFile(new File(source));
        filedata.forEach(System.out::println);

        writeFile(new File(destination), filedata);
        System.out.println("contain copied :)");


    }
}
