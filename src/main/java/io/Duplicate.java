package io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aman on 6/2/17.
 */
public class Duplicate {
    public static List<String> readCsv(File inputFile) {
        try (FileReader fr = new FileReader(inputFile); BufferedReader br = new BufferedReader(fr)) {
            String data;
            List<String> wordList = new ArrayList<>();
            while ((data = br.readLine()) != null) {
                String[] tokens = data.split(",");
                for (String s : tokens) {
                    wordList.add(s);
                }
            }
            return wordList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeCSV(List<String> duplicateRemvoedList, File result) {
        try (FileWriter fw = new FileWriter(result, false); BufferedWriter bw = new BufferedWriter(fw)) {
            for (String data : duplicateRemvoedList) {
                bw.append(data);
                bw.append(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static List<String> removeDuplicate(String input) {
//        String[] words = input.split(" ");
//        List<String> wordsList = Arrays.asList(words);
//        wordsList.forEach(System.out::println);
//        System.out.println("after removing duplicates");
//        Set<String> wordset = new LinkedHashSet<>(wordsList);
//        wordset.forEach(System.out::println);
//    }

    public static List<String> removeDuplicate(List<String> wordsList) {
        System.out.println("after removing duplicates");
        Set<String> wordset = new LinkedHashSet<>(wordsList);
        wordset.forEach(System.out::println);
        List<String> duplicateRemovedList = new ArrayList<>(wordset);
        return duplicateRemovedList;
    }

    public static void main(String[] args) {

//        String input = "hello I am am aman";
//        removeDuplicate(input);
        File file = new File("Words.csv");
        File file2 = new File("final.csv");

        List<String> wordList = readCsv(file);
        wordList.forEach(System.out::println);
        List<String> duplicteRemoveList = removeDuplicate(wordList);
        duplicteRemoveList.forEach(System.out::println);
        writeCSV(duplicteRemoveList, file2);


    }
}
