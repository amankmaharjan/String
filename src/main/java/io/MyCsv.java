package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/1/17.
 */
class Country {

    int code;
    String name;
    String capital;

    public Country(int code, String name, String capital) {
        this.code = code;
        this.name = name;
        this.capital = capital;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "country{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}

public class MyCsv {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int COUNTRY_CODE = 0;
    private static final int COUNTRY_NAME = 1;
    private static final int COUNTRY_CAPITAL = 2;


    public static List<Country> readCsv(File inputFile) {
        try (FileReader fr = new FileReader(inputFile); BufferedReader br = new BufferedReader(fr)) {
            List<Country> countryList = new ArrayList<>();
            String data;
            while ((data = br.readLine()) != null) {
                String[] tokens = data.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Country country = new Country(Integer.parseInt(tokens[COUNTRY_CODE]), tokens[COUNTRY_NAME], tokens[COUNTRY_CAPITAL]);
                    countryList.add(country);
                }
            }
            return countryList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeCSV(List<Country> countries, File result) {
        try (FileWriter fw = new FileWriter(result, false); BufferedWriter bw = new BufferedWriter(fw)) {
            for (Country country : countries) {
                bw.append(String.valueOf(country.getCode()));
                bw.append(COMMA_DELIMITER);
                bw.append(country.getName());
                bw.append(COMMA_DELIMITER);
                bw.append(country.getCapital());
                bw.append(NEW_LINE_SEPARATOR);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file1 = new File(("myCountry.csv"));

        Country country1 = new Country(977, "nepal", "kathmandu");
        Country country2 = new Country(972, "india", "delhi");
        Country country3 = new Country(973, "china", "beijing");
        Country country4 = new Country(974, "bangladesh", "dhajka");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);

        writeCSV(countries, file1);
        List<Country> countryList = new ArrayList<>();
        countryList = readCsv(file1);
        countryList.forEach(System.out::println);

    }
}
