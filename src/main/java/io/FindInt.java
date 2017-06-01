package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/1/17.
 */

public class FindInt {
    static File inputFile = new File("Numbers.txt");
    static File outputFile = new File("Int.txt");


    public static List readFile() {
        try (FileReader fr = new FileReader(inputFile); BufferedReader br = new BufferedReader(fr)) {
            String data;
            List<Long> longList = new ArrayList<>();
            while ((data = br.readLine()) != null) {
                longList.add(Long.parseLong(data));
            }
            return longList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(List<Integer> integerList) {
        try (FileWriter fw = new FileWriter(outputFile, false); BufferedWriter bw = new BufferedWriter(fw)) {
            for (Integer intdata : integerList) {
                bw.write(String.valueOf(intdata));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> convertToint(List<Long> longList) {
        List<Integer> intList = new ArrayList<>();
        for (Long x : longList)
            if (x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE) {
                intList.add(x.intValue());
            } else {
                intList.add(Integer.parseInt((String) String.valueOf(x).subSequence(0, 9)));
            }
        return intList;

    }

    public static void main(String[] args) {
        List<Long> longList = readFile();
        longList.forEach(System.out::println);
        List<Integer> integerList = convertToint(longList);
        integerList.forEach(System.out::println);
        writeFile(integerList);
    }
}
